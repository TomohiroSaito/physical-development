package physicaldevelopment.model.account.authentication;

public class Authentication {
	private LoginId loginId;
	private Password password;

	public Authentication(LoginId loginId, Password password) {
		this.loginId = loginId;
		this.password = password;
	}
	public LoginId getLoginId() {
		return loginId;
	}
	public void setLoginId(LoginId loginId) {
		this.loginId = loginId;
	}
	public Password getPassword() {
		return password;
	}
	public void setPassword(Password password) {
		this.password = password;
	}
}
