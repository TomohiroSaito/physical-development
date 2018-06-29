package physicaldevelopment.controller.loginlogout;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	//ログイン画面の表示
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String viewLogin(Model model) {
		return "login/login";
	}

}
