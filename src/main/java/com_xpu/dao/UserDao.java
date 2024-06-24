package com_xpu.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com_xpu.common.enums.UsersStatus;
import com_xpu.domain.entity.Users;
import com_xpu.mapper.UsersMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserDao {
    @Resource(type = UsersMapper.class)
    private UsersMapper usersMapper;
    public Boolean addUser1(Users user) {
        int insert = usersMapper.insert(user);
        return insert == 1;
    }

    public Users getUserByPhone(String phone) {
        Users users = usersMapper.selectByPhone(phone);
        return users;
    }
    public  Users getUserByUserName(String userName) {
        Users users = usersMapper.selectByUserName(userName);
        return users;
    }
    public Users getUserByUserNameOrPhone(String userNameOrPhone) {
        Users users = usersMapper.selectByUserNameOrPhone(userNameOrPhone);

        return users;
    }
}
