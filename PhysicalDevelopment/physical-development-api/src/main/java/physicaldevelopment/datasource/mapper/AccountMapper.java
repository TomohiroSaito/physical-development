package physicaldevelopment.datasource.mapper;

import org.springframework.stereotype.Repository;

import physicaldevelopment.model.account.Account;

@MyMapper
@Repository
public interface AccountMapper {
	Account selectAccount(String id);
}
