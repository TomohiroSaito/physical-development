package physicaldevelopment.model.account.authentication;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class LoginId {
	@NotBlank(message = "IDは必須です。")
	@Size(min=6, max=12, message="IDは6文字以上12文字以下で入力してください。")
	@Pattern(regexp="^[0-9a-zA-Z]+$", message="IDは英数字で入力してください。")
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
