package com.doanjava.nhom9_chdt.Validator;

import com.doanjava.nhom9_chdt.Validator.annotation.ValidUserId;
import com.doanjava.nhom9_chdt.entity.User;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User> {
    @Override
    public boolean isValid(User user, ConstraintValidatorContext context) {
        if(user == null)
            return true;
        return user.getId()!=null;
    }
}

