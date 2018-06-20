package physicaldevelopment.model.account.authentication;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class LoginId {
	@NotNull(message="必須です。")
	@Min(6)
	private String loginId;

	public LoginId(String loginId) {
		this.loginId = loginId;
	}

	public LoginId() {
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
}
