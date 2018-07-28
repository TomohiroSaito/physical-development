package physicaldevelopment.controller.account.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import physicaldevelopment.model.account.Account;
import physicaldevelopment.service.account.register.AccountRegisterService;

@SessionAttributes(value = "accountSession")
@Controller
public class AccountRegisterController {
	@Autowired
	private AccountRegisterService accountRegisterService;

	@RequestMapping("/accountRegister")
	public String accountRegister(Model model) {
		return "accountregister/accountRegister";
	}

	@RequestMapping(path = "/newMemberRegister", method = RequestMethod.POST)
	public String newMemberRegister(@Validated @ModelAttribute Account account,
			BindingResult bindingResult, Model model) {
		// バリデーション
		if (bindingResult.hasErrors()) {
			// 入力エラーがあれば、会員登録入力画面にエラーを渡す
			List<ObjectError> errors = bindingResult.getAllErrors();
			model.addAttribute("errors", errors);
			return "accountregister/accountRegister";
		}

		// 入力エラーがなければ、会員登録確認画面に遷移
		account.getBirthday().asBirthday();
		model.addAttribute("accountSession", account);

		return "accountregister/confirmAccountRegister";
	}

	@RequestMapping("/checkedMemberRegister")
	public String checkedMemberRegister(Model model,
			@ModelAttribute("accountSession") Account account) {
		// 会員登録が完了すれば、トップページにリダイレクト
		// ※この処理いらない？
		accountRegisterService.registerAccount(account);
		model.addAttribute("message", "isert succesess!!!");
		return "redirect:";
	}

}
