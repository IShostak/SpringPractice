package com.ishostak.mvc;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator
        implements ConstraintValidator<CourseCode, String> {
    private String prefix;

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        prefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;

        if (theCode != null) {
            result = theCode.startsWith(prefix);
        } else {
            result = true;
        }

        return result;
    }
}
