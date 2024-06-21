package com_xpu.common.annotation;

import com_xpu.domain.vo.UserVO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class PasswordValidator implements ConstraintValidator<PasswordEqual, UserVO> {

    @Override
    public void initialize(PasswordEqual constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }


    @Override
    public boolean isValid(UserVO userVO, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.isNull(userVO)) {
            return true;
        }
        return Objects.equals(userVO.getPassword(), userVO.getAgainPassword());
    }
}
