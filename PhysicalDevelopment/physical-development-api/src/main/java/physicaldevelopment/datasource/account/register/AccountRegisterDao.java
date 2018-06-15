package physicaldevelopment.datasource.account.register;

import physicaldevelopment.model.account.Account;

public interface AccountRegisterDao {
	void registerAccount(Account account);

	int selectNextAccountId();
}
