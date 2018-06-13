package physicaldevelopment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import physicaldevelopment.model.meal.Meal;

@SessionAttributes(value="nutritionSession")
@Controller
public class NutritionManualRegisterController {

	@RequestMapping("/inputNutritionManualRegister")
	public String inputNutritionManualRegister(Model model) {
		return "nutritionmanualregister/inputNutritionManualRegister";
	}

	@RequestMapping(path="/checkNutritionManualRegister", method=RequestMethod.POST)
	public String checkNutritionManualRegister(@ModelAttribute Meal meal , Model model) {
		model.addAttribute("nutritionSession", meal);
		return "nutritionmanualregister/checkNutritionManualRegister";
	}

}
