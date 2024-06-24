package com_xpu.common.annotation;

import com_xpu.domain.dto.UserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class PasswordValidator implements ConstraintValidator<PasswordEqual, UserDTO> {

    @Override
    public void initialize(PasswordEqual constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }


    @Override
    public boolean isValid(UserDTO userDTO, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.isNull(userDTO)) {
            return true;
        }
        return userDTO.getPassword().equals(userDTO.getAgainPassword());
    }
}
