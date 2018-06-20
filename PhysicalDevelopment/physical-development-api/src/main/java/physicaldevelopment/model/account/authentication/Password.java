package physicaldevelopment.model.account.authentication;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Password {
	@NotNull(message="必須です。")
	@Min(6)
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
