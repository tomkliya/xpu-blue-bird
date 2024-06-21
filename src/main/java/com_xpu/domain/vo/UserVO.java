package com_xpu.domain.vo;

import com_xpu.common.annotation.PasswordEqual;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@PasswordEqual
public class UserVO {
    @NotBlank
    private String username;

    private String password;

    private String againPassword;

    private String phone;
}
