package physicaldevelopment.controller.nutrition.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import physicaldevelopment.datasource.meal.register.MealRegisterDao;
import physicaldevelopment.model.meal.Meal;
import physicaldevelopment.model.meal.OrderOfMeals;
import physicaldevelopment.model.nutrition.Nutrition;
import physicaldevelopment.service.meal.register.MealRegisterRepository;

@SessionAttributes(value="nutritionSession")
@Controller
public class NutritionRegisterController {
	@Autowired
	MealRegisterRepository mealRegisterRepository;

	@Autowired
	MealRegisterDao mealRegisterDao;

	@RequestMapping("/inputNutritionRegister")
	public String inputNutritionRegister(Model model) {
		int orderOfMeals = mealRegisterDao.selectNextOrderOfMeals();
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
	public String confirmNutritionRegister(Model model, @ModelAttribute("nutritionSession") Meal meal) {
		mealRegisterRepository.registerMealManual(meal);
		model.addAttribute("message", "isert meal succesess!!!");
		return "showMessage";
	}


}
