package com_xpu.common.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = PasswordValidator.class )

public @interface PasswordEqual {
    String message() default "输入的两次密码不匹配";

    // groups和payload方法是注解中必须要有的两个方法
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}