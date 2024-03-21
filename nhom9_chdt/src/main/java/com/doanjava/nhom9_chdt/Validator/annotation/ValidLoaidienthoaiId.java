package com.doanjava.nhom9_chdt.Validator.annotation;
import com.doanjava.nhom9_chdt.Validator.ValidLoaidienthoaiIdValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;

@Target({TYPE, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidLoaidienthoaiIdValidator.class)
@Documented
public @interface ValidLoaidienthoaiId {
    String message() default "Invalid Loai dien thoai ID";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
