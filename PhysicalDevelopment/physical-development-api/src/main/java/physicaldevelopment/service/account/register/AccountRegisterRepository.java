package physicaldevelopment.service.account.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import physicaldevelopment.datasource.account.register.AccountRegisterDao;
import physicaldevelopment.model.account.Account;
import physicaldevelopment.model.account.AccountId;



@Repository
public class AccountRegisterRepository {
	@Autowired
	private AccountRegisterDao accountRegisterDao;

	public void registerAccount(Account account) {
		int accountId = accountRegisterDao.selectNextAccountId();
		account.setAccountId(new AccountId(accountId));
		accountRegisterDao.registerAccount(account);
	}
}
