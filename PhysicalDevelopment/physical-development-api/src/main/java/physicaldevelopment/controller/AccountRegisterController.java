package physicaldevelopment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import physicaldevelopment.model.account.Account;
import physicaldevelopment.service.AccountRegisterRepository;

@SessionAttributes(value="accountSession")
@Controller
public class AccountRegisterController {
	@Autowired
	AccountRegisterRepository accountRegisterRepository;

	@RequestMapping("/memberRegistration")
	public String memberRegistration(Model model) {
		return "accountregister/memberRegistration";
	}

	@RequestMapping(path="/newMemberRegister", method=RequestMethod.POST)
	public String newMemberRegister(@ModelAttribute Account account , Model model) {
		account.getBirthday().asBirthday();
		model.addAttribute("accountSession", account);

		return "accountregister/checkMemberRegistration";
	}

	@RequestMapping("/checkedMemberRegister")
	public String checkedMemberRegister(Model model, @ModelAttribute("accountSession") Account account) {
		accountRegisterRepository.registerAccount(account);
		model.addAttribute("message", "isert succesess!!!");
		return "showMessage";
	}

}
