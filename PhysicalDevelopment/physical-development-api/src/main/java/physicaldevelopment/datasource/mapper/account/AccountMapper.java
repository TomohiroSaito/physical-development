package physicaldevelopment.datasource.mapper.account;

import org.springframework.stereotype.Repository;

import physicaldevelopment.datasource.mapper.MyMapper;
import physicaldevelopment.model.account.Account;

@MyMapper
@Repository
public interface AccountMapper {
	Account selectAccount(String id);
}
