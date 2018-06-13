package physicaldevelopment.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import physicaldevelopment.datasource.mapper.AccountMapper;
import physicaldevelopment.model.account.Account;

@Repository
public class AccountDaoImpl implements AccountDao {
	@Autowired
	private AccountMapper accountMapper;

	@Override
	public Account findAccountById(String id) {
		Account account = accountMapper.selectAccount(id);
		return account;
	}

}
