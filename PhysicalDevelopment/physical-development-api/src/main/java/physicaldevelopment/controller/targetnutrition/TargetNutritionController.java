package physicaldevelopment.controller.targetnutrition;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import physicaldevelopment.model.account.authentication.LoginId;
import physicaldevelopment.model.nutrition.Nutrition;
import physicaldevelopment.model.targetnutrition.TargetNutrition;
import physicaldevelopment.service.targetnutrition.TargetNutritionRepository;
import physicaldevelopment.service.userdetails.AccountUserDetails;

@SessionAttributes("targetNutritionSession")
@Controller
public class TargetNutritionController {
	@Autowired
	TargetNutritionRepository targetNutritionRepository;


	@RequestMapping("/inputTargetNutrition")
	public String inputTargetNutrition() {
		return "targetnutrition/inputTargetNutrition";
	}

	@RequestMapping(path="/checkTargetNutrition", method=RequestMethod.POST)
	public String checkNutritionManualRegister(@ModelAttribute TargetNutrition targetNutrition , Model model) {
		targetNutrition.getEnergyNutrientAmount().setNutrition(Nutrition.ENERGY);
		targetNutrition.getProteinNutrientAmount().setNutrition(Nutrition.PROTEIN);
		targetNutrition.getLipidNutrientAmount().setNutrition(Nutrition.LIPID);
		targetNutrition.getCarbohydrateNutrientAmount().setNutrition(Nutrition.CARBOHYDRATE);
		model.addAttribute("targetNutritionSession", targetNutrition);
		return "targetnutrition/checkTargetNutrition";
	}

	@RequestMapping("/confirmTargetNutrition")
	public String confirmTargetNutrition(Model model, @ModelAttribute("targetNutritionSession") TargetNutrition targetNutrition, Principal principal) {
		Authentication auth = (Authentication)principal;
        AccountUserDetails accountUserDetails = (AccountUserDetails)auth.getPrincipal();
        LoginId loginId = new LoginId();;
        loginId.setLoginId(accountUserDetails.getUsername());
		targetNutritionRepository.setTargetNutrition(targetNutrition, loginId);
		model.addAttribute("message", "isert target succesess!!!");
		return "showMessage";
	}


}