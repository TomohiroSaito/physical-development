package physicaldevelopment.controller.dailynutrition;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import physicaldevelopment.datasource.evaluation.EvaluationDao;
import physicaldevelopment.datasource.targetnutrition.TargetNutritionDao;
import physicaldevelopment.model.account.AccountId;
import physicaldevelopment.model.account.authentication.LoginId;
import physicaldevelopment.model.dailynutrition.DailyNutrientAmountId;
import physicaldevelopment.model.dailynutrition.DailyNutrition;
import physicaldevelopment.model.dailynutrition.TotalNutrientAmountPerDay;
import physicaldevelopment.model.evaluation.Evaluation;
import physicaldevelopment.model.evaluation.NotSubjectToEvaluation;
import physicaldevelopment.model.primitive.YearMonthDay;
import physicaldevelopment.model.targetnutrition.TargetNutrition;
import physicaldevelopment.service.dailynutrition.DailyNutritionService;
import physicaldevelopment.service.evaluation.EvaluationService;
import physicaldevelopment.service.targetnutrition.TargetNutritionService;
import physicaldevelopment.service.userdetails.AccountUserDetails;

@Controller
//@SessionAttributes(types = { Evaluation.class })
public class DailyNutritionController {
	@Autowired
	DailyNutritionService dailyNutritionService;

	@Autowired
	TargetNutritionService targetNutritionService;

	@Autowired
	TargetNutritionDao targetNutritionDao;

	@Autowired
	EvaluationService evaluationService;

	@Autowired
	EvaluationDao evaluationDao;

	@RequestMapping(path={"/", "toppage"})
	public String toppage(Principal principal, Model model) {
		//アカウントIDの取得
		Authentication auth = (Authentication)principal;
        AccountUserDetails accountUserDetails = (AccountUserDetails)auth.getPrincipal();
        LoginId loginId = new LoginId(accountUserDetails.getUsername());
		AccountId accountId = new AccountId(targetNutritionDao.selectAccountId(loginId));

		Date today = new Date();
		DailyNutrientAmountId dailyNutrientAmountId = dailyNutritionService.selectDailyNutritionId(today, accountId);

		//1日の栄養、目標栄養を取得
		TotalNutrientAmountPerDay totalNutrientAmountPerDay = dailyNutritionService.createTotalNutrientAmountPerDay(dailyNutrientAmountId);
		TargetNutrition targetNutrition = targetNutritionService.selectTargetNutrientAmount(accountId);

		//目標を設定していない場合は目標設定画面に遷移
		if(null == targetNutrition) {
			return "redirect:inputTargetNutrition";
		}

		DailyNutrition dailyNutrition = new DailyNutrition(totalNutrientAmountPerDay, targetNutrition, new YearMonthDay(today));
		model.addAttribute("dailyNutrition", dailyNutrition);

		//評価計算
		Evaluation evaluation = evaluationService.calcEvaluation(today, accountId);
		System.out.println();
		model.addAttribute("evaluation", evaluation);
		model.addAttribute("yearMonthDay", new YearMonthDay(today));
		return "dailynutrition/dispDailyNutrition";
	}

	@RequestMapping("/notSubjectToEvaluation")
	public String notSubjectToEvaluation(Model model, NotSubjectToEvaluation notSubjectToEvaluation, Principal principal) {
		Authentication auth = (Authentication)principal;
        AccountUserDetails accountUserDetails = (AccountUserDetails)auth.getPrincipal();
        LoginId loginId = new LoginId(accountUserDetails.getUsername());
		AccountId accountId = new AccountId(targetNutritionDao.selectAccountId(loginId));

		Date date = new Date();
		DailyNutrientAmountId dailyNutrientAmountId = dailyNutritionService.selectDailyNutritionId(date, accountId);

		evaluationService.upsertNotSubjectToEvaluation(dailyNutrientAmountId, notSubjectToEvaluation);
		Evaluation tempEvaluation = evaluationDao.selectEvaluation(dailyNutrientAmountId);
		Evaluation evaluation = new Evaluation(tempEvaluation, notSubjectToEvaluation);
		model.addAttribute("evaluation", evaluation);
		return "dailynutrition/evaluation";
	}

}
