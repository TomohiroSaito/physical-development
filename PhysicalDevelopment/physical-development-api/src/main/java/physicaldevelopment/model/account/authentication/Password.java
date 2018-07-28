package physicaldevelopment.model.account.authentication;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Password {
	@NotBlank(message = "パスワードは必須です。")
	@Size(min = 6, max = 12, message = "パスワードは6文字以上12文字以下で入力してください。")
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9]).*", message = "パスワードは英数字の組み合わせで入力してください。")
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
