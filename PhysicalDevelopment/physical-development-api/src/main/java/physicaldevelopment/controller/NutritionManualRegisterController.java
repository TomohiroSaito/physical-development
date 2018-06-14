package physicaldevelopment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import physicaldevelopment.datasource.MealRegisterDao;
import physicaldevelopment.model.meal.Meal;
import physicaldevelopment.model.meal.OrderOfMeals;
import physicaldevelopment.model.nutrition.Nutrition;
import physicaldevelopment.service.MealRegisterRepository;

@SessionAttributes(value="nutritionSession")
@Controller
public class NutritionManualRegisterController {
	@Autowired
	MealRegisterRepository mealRegisterRepository;

	@Autowired
	MealRegisterDao mealRegisterDao;

	@RequestMapping("/inputNutritionManualRegister")
	public String inputNutritionManualRegister(Model model) {
		int orderOfMeals = mealRegisterDao.selectNextOrderOfMeals();
//		int orderOfMeals = 1;
		model.addAttribute("orderOfMeals", orderOfMeals);
		return "nutritionmanualregister/inputNutritionManualRegister";
	}

	@RequestMapping(path="/checkNutritionManualRegister", method=RequestMethod.POST)
	public String checkNutritionManualRegister(@ModelAttribute Meal meal , Model model, String strOrderOfMeals) {
		meal.setOrderOfMeals(new OrderOfMeals(Integer.parseInt(strOrderOfMeals)));
		meal.getYearMonthDay().asYearMonthDay();
		meal.getOneMealOfNutrients().getEnergyNutrientAmount().setNutrition(Nutrition.ENERGY);
		meal.getOneMealOfNutrients().getProteinNutrientAmount().setNutrition(Nutrition.PROTEIN);
		meal.getOneMealOfNutrients().getLipidNutrientAmount().setNutrition(Nutrition.LIPID);
		meal.getOneMealOfNutrients().getCarbohydrateNutrientAmount().setNutrition(Nutrition.CARBOHYDRATE);
		model.addAttribute("nutritionSession", meal);
		return "nutritionmanualregister/checkNutritionManualRegister";
	}

	@RequestMapping("/confirmNutritionManualRegister")
	public String confirmNutritionManualRegister(Model model, @ModelAttribute("nutritionSession") Meal meal) {
		mealRegisterRepository.registerMealManual(meal);
		model.addAttribute("message", "isert meal succesess!!!");
		return "showMessage";
	}


}
