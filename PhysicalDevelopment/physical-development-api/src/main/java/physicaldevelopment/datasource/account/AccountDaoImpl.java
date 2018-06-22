package physicaldevelopment.datasource.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import physicaldevelopment.datasource.mapper.account.AccountMapper;
import physicaldevelopment.model.account.Account;
import physicaldevelopment.model.account.authentication.LoginId;

@Repository
public class AccountDaoImpl implements AccountDao {
	@Autowired
	private AccountMapper accountMapper;

	@Override
	public Account findAccountById(String id) {
		Account account = accountMapper.selectAccount(id);
		return account;
	}

	@Override
	public Integer existLoginId(LoginId loginId) {
		Integer countLoginId = accountMapper.existLoginId(loginId);
		return countLoginId;
	}

}
