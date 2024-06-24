package com_xpu.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginDTO {


         @NotBlank
         private String userNameOrPhone;
        @NotBlank
        private String password;


}
