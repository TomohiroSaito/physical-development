package physicaldevelopment.datasource;

import physicaldevelopment.model.account.Account;

public interface AccountDao {

	Account findAccountById(String id);
}
