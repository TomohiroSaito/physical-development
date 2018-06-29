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
		//会員IDの取得
		Authentication auth = (Authentication)principal;
        AccountUserDetails accountUserDetails = (AccountUserDetails)auth.getPrincipal();
        LoginId loginId = new LoginId(accountUserDetails.getUsername());
		AccountId accountId = new AccountId(targetNutritionDao.selectAccountId(loginId));

		//今日の1日の栄養素IDを取得
		Date today = new Date();
		DailyNutrientAmountId dailyNutrientAmountId = dailyNutritionService.selectDailyNutritionId(today, accountId);

		//1日の栄養、目標栄養を取得
		TotalNutrientAmountPerDay totalNutrientAmountPerDay = dailyNutritionService.createTotalNutrientAmountPerDay(dailyNutrientAmountId);
		TargetNutrition targetNutrition = targetNutritionService.selectTargetNutrientAmount(accountId);

		//目標を設定していない場合は目標設定画面に遷移
		if(null == targetNutrition) {
			return "redirect:targetNutrition";
		}

		//取得した1日の栄養、目標栄養、今日の日付から1日の栄養モデルを作成
		DailyNutrition dailyNutrition = new DailyNutrition(totalNutrientAmountPerDay, targetNutrition, new YearMonthDay(today));
		model.addAttribute("dailyNutrition", dailyNutrition);

		//評価計算
		Evaluation evaluation = evaluationService.calcEvaluation(today, accountId);

		model.addAttribute("evaluation", evaluation);
		model.addAttribute("yearMonthDay", new YearMonthDay(today));
		return "dailynutrition/dailyNutrition";
	}

	@RequestMapping("/notSubjectToEvaluation")
	public String notSubjectToEvaluation(Model model, NotSubjectToEvaluation notSubjectToEvaluation, Principal principal) {
		//会員IDの取得
		Authentication auth = (Authentication)principal;
        AccountUserDetails accountUserDetails = (AccountUserDetails)auth.getPrincipal();
        LoginId loginId = new LoginId(accountUserDetails.getUsername());
		AccountId accountId = new AccountId(targetNutritionDao.selectAccountId(loginId));

		//今日の日付を取得
		Date date = new Date();

		//日付と会員IDから1日の栄養素IDを取得
		DailyNutrientAmountId dailyNutrientAmountId = dailyNutritionService.selectDailyNutritionId(date, accountId);

		//評価テーブルが存在すれば更新、
		//存在しなければ評価テーブルの挿入
		evaluationService.upsertNotSubjectToEvaluation(dailyNutrientAmountId, notSubjectToEvaluation);

		//取得した1日の栄養素IDから栄養素モデルを取得
		Evaluation evaluation = evaluationDao.selectEvaluation(dailyNutrientAmountId);

		model.addAttribute("evaluation", evaluation);
		return "dailynutrition/evaluation";
	}

}
