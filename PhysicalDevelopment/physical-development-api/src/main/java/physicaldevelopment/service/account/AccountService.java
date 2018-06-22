package physicaldevelopment.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import physicaldevelopment.datasource.account.AccountDao;
import physicaldevelopment.model.account.Account;
import physicaldevelopment.model.account.authentication.LoginId;

@Service
public class AccountService {
	@Autowired
	private AccountDao accountDao;

	public Account findOne(String username) {
		Account account = accountDao.findAccountById(username);
		return account;
	}

	public boolean existLoginId(LoginId loginId) {
		Integer countLoginId = accountDao.existLoginId(loginId);
		if(countLoginId == 0 || countLoginId == null) {
			return false;
		}
		return true;
	}

}
