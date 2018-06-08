package physicaldevelopment.service.dataaccess;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import physicaldevelopment.datasource.mapper.AccountRegisterMapper;
import physicaldevelopment.model.account.Account;

@Repository
public class AccountRegisterDaoImpl implements AccountRegisterDao {
	@Autowired
	AccountRegisterMapper accountRegisterMapper;

	public void registerAccount(Account account) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("loginId", account.getAuthentication().getLoginId().getLoginId());
		hashMap.put("password", account.getAuthentication().getPassword().getPassword());
		accountRegisterMapper.insertAccount(hashMap);
	}
}
