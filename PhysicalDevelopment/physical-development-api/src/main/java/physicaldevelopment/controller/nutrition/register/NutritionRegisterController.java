package physicaldevelopment.controller.nutrition.register;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import physicaldevelopment.datasource.targetnutrition.TargetNutritionDao;
import physicaldevelopment.model.account.AccountId;
import physicaldevelopment.model.account.authentication.LoginId;
import physicaldevelopment.model.meal.Meal;
import physicaldevelopment.model.meal.OrderOfMeals;
import physicaldevelopment.model.nutrition.Nutrition;
import physicaldevelopment.model.primitive.YearMonthDay;
import physicaldevelopment.service.meal.register.MealRegisterService;
import physicaldevelopment.service.userdetails.AccountUserDetails;

@SessionAttributes(value="nutritionSession")
@Controller
public class NutritionRegisterController {
	@Autowired
	MealRegisterService mealRegisterService;

	@Autowired
	TargetNutritionDao targetNutritionDao;

	@RequestMapping("/inputNutritionRegister")
	public String inputNutritionRegister(Model model, Principal principal) {
		Authentication auth = (Authentication)principal;
        AccountUserDetails accountUserDetails = (AccountUserDetails)auth.getPrincipal();
        LoginId loginId = new LoginId(accountUserDetails.getUsername());
        Date today = new Date();
        model.addAttribute("today", today.getTime());
        YearMonthDay yearMonthDay = new YearMonthDay(today);
		int orderOfMeals = mealRegisterService.selectNextOrderOfMeals(yearMonthDay, loginId);
//		int orderOfMeals = 1;
		model.addAttribute("orderOfMeals", orderOfMeals);
		return "nutritionregister/inputNutritionRegister";
	}

	@RequestMapping(path="/checkNutritionRegister", method=RequestMethod.POST)
	public String checkNutritionRegister(@ModelAttribute Meal meal , Model model, String strOrderOfMeals) {
		meal.setOrderOfMeals(new OrderOfMeals(Integer.parseInt(strOrderOfMeals)));
		meal.getYearMonthDay().asYearMonthDay();
		meal.getOneMealOfNutrients().getEnergyNutrientAmount().setNutrition(Nutrition.ENERGY);
		meal.getOneMealOfNutrients().getProteinNutrientAmount().setNutrition(Nutrition.PROTEIN);
		meal.getOneMealOfNutrients().getLipidNutrientAmount().setNutrition(Nutrition.LIPID);
		meal.getOneMealOfNutrients().getCarbohydrateNutrientAmount().setNutrition(Nutrition.CARBOHYDRATE);
		model.addAttribute("nutritionSession", meal);
		return "nutritionregister/checkNutritionRegister";
	}

	@RequestMapping("/confirmNutritionRegister")
	public String confirmNutritionRegister(Model model, @ModelAttribute("nutritionSession") Meal meal, Principal principal) {
		//会員IDの取得
		Authentication auth = (Authentication)principal;
        AccountUserDetails accountUserDetails = (AccountUserDetails)auth.getPrincipal();
        LoginId loginId = new LoginId(accountUserDetails.getUsername());
		AccountId accountId = new AccountId(targetNutritionDao.selectAccountId(loginId));

		//食事の登録
		mealRegisterService.registerMeal(meal, accountId);
		model.addAttribute("message", "isert meal succesess!!!");
		return "redirect:";
	}


}
