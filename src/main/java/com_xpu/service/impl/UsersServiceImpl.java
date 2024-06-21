package com_xpu.service.impl;

import com_xpu.dao.UserDao;
import com_xpu.domain.entity.Users;
import com_xpu.domain.vo.UserVO;
import com_xpu.exception.EmptyFileException;
import com_xpu.exception.PasswordErrorException;
import com_xpu.mapper.UsersMapper;
import com_xpu.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com_xpu.service.impl.adapter.UserAdapter;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author knghuarui
 * @since 2024-06-21
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

    @Resource(type = UserDao.class)
    private UserDao userDao;
    @Resource(type = UserAdapter.class)
    private UserAdapter userAdapter;
    //用户注册
    public boolean saveUser(UserVO userVO) {

        Users users = userAdapter.returnUser(userVO);

        return userDao.addUser1(users);

    }

    }
