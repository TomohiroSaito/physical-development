package physicaldevelopment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import physicaldevelopment.service.dataaccess.AccountRegisterRepository;


@Service
public class AccountUserDetailsService implements UserDetailsService {

    @Autowired
    AccountRegisterRepository accountRegisterRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}