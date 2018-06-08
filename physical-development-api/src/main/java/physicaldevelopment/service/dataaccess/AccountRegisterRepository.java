package physicaldevelopment.service.dataaccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import physicaldevelopment.model.account.Account;



@Repository
public class AccountRegisterRepository {
	@Autowired
	private AccountRegisterDao accountRegisterDao;

	public void registerAccount(Account account) {
		accountRegisterDao.registerAccount(account);
	}
}
