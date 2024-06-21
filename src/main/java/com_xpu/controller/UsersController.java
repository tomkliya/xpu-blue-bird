package com_xpu.controller;


import com_xpu.domain.entity.Result;
import com_xpu.domain.entity.Users;
import com_xpu.domain.vo.UserVO;
import com_xpu.service.impl.UsersServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
public class UsersController {

    @Resource(type = UsersServiceImpl.class)
    private UsersServiceImpl usersService;

    @ApiOperation("注册接口")
    @PostMapping("/save")
    public Result save(@RequestBody UserVO userVO) {
        boolean b = usersService.saveUser(userVO);
        return b?Result.success("注册成功"):Result.error("注册失败");
    }

}
