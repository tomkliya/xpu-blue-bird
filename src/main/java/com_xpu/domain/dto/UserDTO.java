package com_xpu.domain.dto;

import com_xpu.common.annotation.PasswordEqual;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@PasswordEqual()
public class UserDTO {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String againPassword;
    @NotBlank
    @Pattern(regexp = "^1[3-9]\\d{9}$")
    private String phone;
}
