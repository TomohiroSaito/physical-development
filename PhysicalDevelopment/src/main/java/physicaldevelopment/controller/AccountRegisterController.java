package physicaldevelopment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import physicaldevelopment.model.account.Account;
import physicaldevelopment.service.dataaccess.AccountRegisterRepository;

//@SessionAttributes("account")
@Controller
public class AccountRegisterController {
	@Autowired
	AccountRegisterRepository accountRegisterRepository;
	
	@RequestMapping("/memberRegistration")
	public String memberRegistration(Model model) {
		return "memberRegistration";
	}
	
	@RequestMapping("/newMemberRegister")
	public String newMemberRegister(@ModelAttribute Account account ,
			//LoginId loginId, Password password,
			Model model) {
//		Account account = new Account(loginId, password);
		model.addAttribute("account", account);
		
		return "checkMemberRegistration";
	}

	@RequestMapping("/checkedMemberRegister")
	public String checkedMemberRegister(Model model, Account account) {
		accountRegisterRepository.registerAccount(account);
		model.addAttribute("message", "isert succesess!!!");
		return "showMessage";
	}

}
