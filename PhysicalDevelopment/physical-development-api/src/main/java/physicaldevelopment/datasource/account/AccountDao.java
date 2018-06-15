package physicaldevelopment.datasource.account;

import physicaldevelopment.model.account.Account;

public interface AccountDao {

	Account findAccountById(String id);
}
