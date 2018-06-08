package physicaldevelopment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	@RequestMapping("/logoutSuccess")
	public String logoutSuccess(Model model) {
		model.addAttribute("message", "logoutSuccess is okay!");
		return "logoutDisp";
	}
}
