package physicaldevelopment.datasource.mapper.account;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import physicaldevelopment.datasource.mapper.MyMapper;
import physicaldevelopment.model.account.Account;
import physicaldevelopment.model.account.authentication.LoginId;

@MyMapper
@Repository
public interface AccountMapper {
	Account selectAccount(String id);

	Integer existLoginId(@Param("loginId") LoginId loginId);
}
