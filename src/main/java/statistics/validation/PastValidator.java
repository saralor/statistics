package statistics.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.lang.System.currentTimeMillis;

public class PastValidator implements ConstraintValidator<Past, Long> {

    @Override
    public void initialize(Past constraintAnnotation) {
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        } else {
            return value < currentTimeMillis();
        }
    }

}
