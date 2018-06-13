package physicaldevelopment.model.account;

import physicaldevelopment.model.account.authentication.Authentication;
import physicaldevelopment.model.account.authentication.LoginId;
import physicaldevelopment.model.account.authentication.Password;
import physicaldevelopment.model.account.profile.Birthday;
import physicaldevelopment.model.primitive.Sex;

public class Account {
	private AccountId accountId;
	private Authentication authentication;
	private Birthday birthday;
	private Sex sex;
	public Account(LoginId loginId, Password password) {
		this.authentication = new Authentication(loginId, password);
	}
	public AccountId getAccountId() {
		return accountId;
	}
	public void setAccountId(AccountId accountId) {
		this.accountId = accountId;
	}
	public Authentication getAuthentication() {
		return authentication;
	}
	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}
	public Birthday getBirthday() {
		return birthday;
	}
	public void setBirthday(Birthday birthday) {
		this.birthday = birthday;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
