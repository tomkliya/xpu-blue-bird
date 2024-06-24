package com_xpu.controller;


import com_xpu.domain.dto.LoginDTO;
import com_xpu.domain.entity.Result;
import com_xpu.domain.dto.UserDTO;
import com_xpu.service.impl.UsersServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author knghuarui
 * @since 2024-06-21
 */
@RestController
@RequestMapping("/users")
@Api(tags = "用户相关接口")
@Slf4j
public class UsersController {

    @Resource(type = UsersServiceImpl.class)
    private UsersServiceImpl usersService;

    @ApiOperation("注册接口")
    @PostMapping("/register")
    public Result save(@RequestBody @Valid UserDTO userDTO) {
        log.info("用户注册userDTO:{}",userDTO);
        return usersService.saveUser(userDTO)?Result.success("注册成功"):Result.error("注册失败");
    }

    @ApiOperation("登录接口")
    @PostMapping("/login")
    public Result login(@RequestBody @Valid LoginDTO loginDTO, HttpSession session) {
        log.info("用户登录loginDTO:{}",loginDTO);
        return usersService.login(loginDTO,session)?Result.success("登录成功"):Result.error("登录失败");

    }
}
