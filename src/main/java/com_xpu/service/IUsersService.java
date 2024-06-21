package com_xpu.service;

import com_xpu.domain.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;
import com_xpu.domain.vo.UserVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author knghuarui
 * @since 2024-06-21
 */
public interface IUsersService extends IService<Users> {



    boolean saveUser(UserVO userVO);
}
