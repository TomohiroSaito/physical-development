package physicaldevelopment.service.userdetails;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import physicaldevelopment.model.account.Account;
import physicaldevelopment.service.account.AccountService;

@Service
public class AccountUserDetailsService implements UserDetailsService {

    @Autowired
    AccountService accountService;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
                    throws UsernameNotFoundException {
            Account account = Optional.ofNullable(accountService.findOne(username))
                            .orElseThrow(() -> new UsernameNotFoundException("user not found."));
            return new AccountUserDetails(account, getAuthorities(account));
    }

    private Collection<GrantedAuthority> getAuthorities(Account account) {
            if(account.isAdmin()) {
                    return AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
            } else {
                    return AuthorityUtils.createAuthorityList("ROLE_USER");
            }
    }}
