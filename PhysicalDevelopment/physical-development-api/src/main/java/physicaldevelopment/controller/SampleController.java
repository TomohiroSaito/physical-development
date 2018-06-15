package physicaldevelopment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import physicaldevelopment.model.account.Account;
import physicaldevelopment.service.account.AccountRepository;

@Controller
public class SampleController {
    @Autowired
    AccountRepository accountRepository;

    @RequestMapping("/sample")
    public Account loadUserByUsername() {
            Account account = accountRepository.findOne("saito");
            return account;
    }

}
