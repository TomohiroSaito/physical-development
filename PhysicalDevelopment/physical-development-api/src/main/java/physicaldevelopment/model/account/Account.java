package physicaldevelopment.model.account;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;

import org.hibernate.validator.constraints.NotEmpty;

import physicaldevelopment.model.account.authentication.Authentication;
import physicaldevelopment.model.account.authentication.LoginId;
import physicaldevelopment.model.account.authentication.Password;
import physicaldevelopment.model.account.profile.Birthday;
import physicaldevelopment.model.primitive.Sex;
import physicaldevelopment.service.annotation.LoginIdValid;

@LoginIdValid
public class Account {
	private AccountId accountId;
	@Valid
	private Authentication authentication;
	@Valid
	private Birthday birthday;
	private Sex sex;
	@NotEmpty(message = "性別を選択してください。")
	private String stringSex;

	public Account() {
	}

	public Account(AccountId accountId, Account accont) {
		this.accountId = accountId;
		this.authentication = accont.getAuthentication();
		this.birthday = accont.getBirthday();
	}

	public Account(AccountId accountId, Authentication authentication,
			Birthday birthday, Sex sex) {
		this.accountId = accountId;
		this.authentication = authentication;
		this.birthday = birthday;
		this.sex = sex;
	}

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

	public String getStringSex() {
		return stringSex;
	}

	public void setStringSex(String stringSex) {
		Sex sex = Sex.getTypeByValue(stringSex);
		if (sex == null) {
			sex = Sex.OTHER;
		}
		this.sex = sex;
		this.stringSex = stringSex;
	}

	@AssertTrue(message = "性別を正しく入力してください。")
	public boolean isConditionSex() {
		if (sex.name() == "OTHER") {
			return false;
		}
		return true;
	}

	@AssertTrue(message = "日付を正しく入力してください。")
	public boolean isConditionBirthday() {
		boolean result = true;
		try {
			birthday.checkFormatDate();
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	public boolean isEnabled() {
		return true;
	}

	public boolean isAdmin() {
		return true;
	}
}
