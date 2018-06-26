package physicaldevelopment.controller.dailynutrition;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

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
@SessionAttributes("dailyNutritionSession")
public class DailyNutritionController {
	@Autowired
	DailyNutritionService dailyNutritionService;

	@Autowired
	TargetNutritionService targetNutritionService;

	@Autowired
	TargetNutritionDao targetNutritionDao;

	@Autowired
	EvaluationService evaluationService;

	@RequestMapping(path={"/", "toppage"})
	public String toppage(Principal principal, Model model) {
		Authentication auth = (Authentication)principal;
        AccountUserDetails accountUserDetails = (AccountUserDetails)auth.getPrincipal();
        LoginId loginId = new LoginId(accountUserDetails.getUsername());
		AccountId accountId = new AccountId(targetNutritionDao.selectAccountId(loginId));
		Date today = new Date();
		DailyNutrientAmountId dailyNutrientAmountId = dailyNutritionService.selectDailyNutritionId(today, accountId);
		TotalNutrientAmountPerDay totalNutrientAmountPerDay = dailyNutritionService.createTotalNutrientAmountPerDay(dailyNutrientAmountId);
		TargetNutrition targetNutrition = targetNutritionService.selectTargetNutrientAmount(accountId);
		if(null == targetNutrition) {
			return "redirect:inputTargetNutrition";
		}
		DailyNutrition dailyNutrition = new DailyNutrition(totalNutrientAmountPerDay, targetNutrition, new YearMonthDay(today));
		model.addAttribute("dailyNutrition", dailyNutrition);
		Evaluation evaluation = evaluationService.calcEvaluation(today, accountId);
		model.addAttribute("evaluation", evaluation);
//		setEvaluation(evaluation);
		model.addAttribute("yearMonthDay", new YearMonthDay(today));
		return "dailynutrition/dispDailyNutrition";
	}

	@RequestMapping("/notSubjectToEvaluation")
	public String checkedMemberRegister(Model model, String judge) {
		if(judge.equals("not")) {
		NotSubjectToEvaluation notSubjectToEvaluation = new NotSubjectToEvaluation(true);
		model.addAttribute("notSubjectToEvaluation", notSubjectToEvaluation);
		}
		return "dailynutrition/evaluation";
	}

//	@ModelAttribute("dailyNutritionSession")
//	private Evaluation setEvaluation(Evaluation evaluation) {
//		return evaluation;
//	}


}
