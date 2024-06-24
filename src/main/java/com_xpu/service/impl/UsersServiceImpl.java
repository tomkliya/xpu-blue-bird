package com_xpu.service.impl;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com_xpu.dao.UserDao;
import com_xpu.domain.dto.LoginDTO;
import com_xpu.domain.entity.Users;
import com_xpu.domain.dto.UserDTO;

import com_xpu.exception.BaseException;
import com_xpu.mapper.UsersMapper;
import com_xpu.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com_xpu.service.impl.adapter.UserAdapter;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Objects;

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
    @Value("${blue-bird.secret}")
    private String secret;

    /**
     * 用户注册
     * @param userDTO
     * @return
     */
    @ApiOperation("用户注册")
    public boolean saveUser(UserDTO userDTO) {
        Users user = userDao.getUserByPhone(userDTO.getPhone());
        if (user != null) {
            throw new BaseException("该用户已经存在了");
        }

        Users users = userAdapter.returnUser(userDTO);
        // 对密码进行加密
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, secret.getBytes());
        users.setPassword(aes.encryptHex(users.getPassword()));

        Boolean insert = userDao.addUser1(users);
        if (!insert) {
            throw new BaseException("用户注册失败");
        }

        return true;

    }

    @Override
    public Boolean login(LoginDTO loginDTO, HttpSession session) {
        // 首先先去数据库里查询用户，看看用户是否存在
        Users user = userDao.getUserByUserNameOrPhone(loginDTO.getUserNameOrPhone());
        if (user == null) {
            throw new BaseException("该用户不存在");
        }
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, secret.getBytes());
        String password = aes.decryptStr(user.getPassword(), CharsetUtil.CHARSET_UTF_8);
        if (!Objects.equals(password, loginDTO.getPassword())) {
            throw new BaseException("密码不正确，请确认后重试");
        }
        // 用户存在，密码正确，那就设置 session
        session.setAttribute("user", user);

        return  true;
    }


    }
