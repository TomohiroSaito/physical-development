package physicaldevelopment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import physicaldevelopment.model.account.Account;
import physicaldevelopment.service.account.AccountService;

@Controller
public class SampleController {
    @Autowired
    AccountService accountService;

    @RequestMapping("/sample")
    public Account loadUserByUsername() {
            Account account = accountService.findOne("saito");
            return account;
    }

}
