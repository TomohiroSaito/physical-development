package physicaldevelopment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String viewLoginForm(Model model) {
		model.addAttribute("message", "jdiekd");
		return "loginForm";
	}

	@RequestMapping("/")
	public String hello(Model model) {
		model.addAttribute("message", "login success!!!!");
		return "showMessage";
	}
}
