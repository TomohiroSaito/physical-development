package physicaldevelopment.datasource.mapper;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository
@MyMapper
public interface AccountRegisterMapper {
	void insertAccount(HashMap<String, String> hashMap);
}
