package physicaldevelopment.service.account.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import physicaldevelopment.datasource.account.register.AccountRegisterDao;
import physicaldevelopment.model.account.Account;
import physicaldevelopment.model.account.AccountId;

@Service
public class AccountRegisterService {
	@Autowired
	private AccountRegisterDao accountRegisterDao;

	public void registerAccount(Account account) {
		int accountId = accountRegisterDao.selectNextAccountId();
		Account newAccount = new Account(new AccountId(accountId),
				account.getAuthentication(), account.getBirthday(),
				account.getSex());
		accountRegisterDao.registerAccount(newAccount);
	}
}
