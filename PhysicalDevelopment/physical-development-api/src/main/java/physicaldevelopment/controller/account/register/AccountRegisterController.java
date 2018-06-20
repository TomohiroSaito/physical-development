package physicaldevelopment.controller.account.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import physicaldevelopment.model.account.Account;
import physicaldevelopment.service.account.register.AccountRegisterService;

@SessionAttributes(value="accountSession")
@Controller
public class AccountRegisterController {
	@Autowired
	AccountRegisterService accountRegisterService;

	@RequestMapping("/memberRegistration")
	public String memberRegistration(Model model) {
		return "accountregister/memberRegistration";
	}

	@RequestMapping(path="/newMemberRegister", method=RequestMethod.POST)
	public String newMemberRegister(@Validated @ModelAttribute Account account , BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "accountregister/memberRegistration";
		}
		account.getBirthday().asBirthday();
		model.addAttribute("accountSession", account);

		return "accountregister/checkMemberRegistration";
	}

	@RequestMapping("/checkedMemberRegister")
	public String checkedMemberRegister(Model model, @ModelAttribute("accountSession") Account account) {
		accountRegisterService.registerAccount(account);
		model.addAttribute("message", "isert succesess!!!");
		return "redirect:";
	}

}
