package physicaldevelopment.datasource.mapper.account.register;

import org.springframework.stereotype.Repository;

import physicaldevelopment.datasource.mapper.MyMapper;
import physicaldevelopment.model.account.Account;

@Repository
@MyMapper
public interface AccountRegisterMapper {
	void insertAccount(Account account);

	void insertAccountAccount(Account account);

	void insertAccountProfile(Account account);

	int selectNextAccountId();
}
