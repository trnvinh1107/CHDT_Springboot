package com.doanjava.nhom9_chdt.Validator;

import com.doanjava.nhom9_chdt.Validator.annotation.ValidLoaidienthoaiId;
import com.doanjava.nhom9_chdt.entity.Loaidienthoai;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidLoaidienthoaiIdValidator implements ConstraintValidator<ValidLoaidienthoaiId, Loaidienthoai> {
    @Override
    public boolean isValid(Loaidienthoai loaidienthoai, ConstraintValidatorContext context) {
        return  loaidienthoai != null && loaidienthoai.getId() != null;
    }
}
