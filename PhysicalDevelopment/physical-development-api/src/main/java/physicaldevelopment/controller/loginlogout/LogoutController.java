package physicaldevelopment.controller.loginlogout;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	@RequestMapping("/logoutSuccess")
	public String logoutSuccess(Model model) {
		//ログアウト成功した際にこの処理に遷移
		//※このコントローラー自体いらない？
		model.addAttribute("message", "ログアウトしました。");
		return "logout/logoutDisp";
	}

}
