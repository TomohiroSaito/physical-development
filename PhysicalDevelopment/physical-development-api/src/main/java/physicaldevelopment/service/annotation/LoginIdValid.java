package physicaldevelopment.service.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = InputLoginIdValidator.class)
@Documented
public @interface LoginIdValid {
	String message() default "IDが重複しています。";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
