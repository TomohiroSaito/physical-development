package physicaldevelopment.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import physicaldevelopment.datasource.mapper.AccountRegisterMapper;
import physicaldevelopment.model.account.Account;

@Repository
public class AccountRegisterDaoImpl implements AccountRegisterDao {
	@Autowired
	AccountRegisterMapper accountRegisterMapper;

	public void registerAccount(Account account) {
		accountRegisterMapper.insertAccountAccount(account);
		accountRegisterMapper.insertAccountProfile(account);
	}

	@Override
	public int selectNextAccountId() {
		return accountRegisterMapper.selectNextAccountId();
	}
}
