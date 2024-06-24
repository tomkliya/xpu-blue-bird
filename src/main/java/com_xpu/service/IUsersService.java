package com_xpu.service;

import com_xpu.domain.dto.LoginDTO;
import com_xpu.domain.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;
import com_xpu.domain.dto.UserDTO;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author knghuarui
 * @since 2024-06-21
 */
public interface IUsersService extends IService<Users> {



    boolean saveUser(UserDTO userDTO);


     Boolean login(LoginDTO req, HttpSession session);
}
