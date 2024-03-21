package com.doanjava.nhom9_chdt.Validator;

import com.doanjava.nhom9_chdt.Validator.annotation.ValidUsername;
import com.doanjava.nhom9_chdt.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor

public class ValidUsernameValidator implements ConstraintValidator<ValidUsername, String> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValid(String userName, ConstraintValidatorContext context) {
        if (userRepository == null) {
            return true;
        }
        return userRepository.findByUsername(userName) == null;
    }
}
