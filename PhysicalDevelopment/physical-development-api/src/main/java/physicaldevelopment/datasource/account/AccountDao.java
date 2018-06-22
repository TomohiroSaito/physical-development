package physicaldevelopment.datasource.account;

import physicaldevelopment.model.account.Account;
import physicaldevelopment.model.account.authentication.LoginId;

public interface AccountDao {

	Account findAccountById(String id);

	Integer existLoginId(LoginId loginId);
}
