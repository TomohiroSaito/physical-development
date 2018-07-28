package physicaldevelopment.service.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import physicaldevelopment.model.account.Account;
import physicaldevelopment.service.account.AccountService;

public class InputLoginIdValidator implements
		ConstraintValidator<LoginIdValid, Account> {

	@Autowired
	private AccountService accountService;

	private LoginIdValid loginIdValid;

	@Override
	public void initialize(LoginIdValid constraintAnnotation) {
		// TODO 自動生成されたメソッド・スタブ
		this.loginIdValid = constraintAnnotation;
	}

	@Override
	public boolean isValid(Account account, ConstraintValidatorContext context) {
		if (accountService.existLoginId(account.getAuthentication()
				.getLoginId())) {
			return false;
		}
		return true;
	}

}
