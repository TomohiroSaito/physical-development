package physicaldevelopment.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import physicaldevelopment.datasource.account.AccountDao;
import physicaldevelopment.model.account.Account;

@Service
public class AccountService {
	@Autowired
	private AccountDao accountDao;

	public Account findOne(String username) {
		Account account = accountDao.findAccountById(username);
		return account;
	}

}
