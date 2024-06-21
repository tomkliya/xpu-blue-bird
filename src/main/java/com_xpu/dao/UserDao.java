package com_xpu.dao;

import com_xpu.domain.entity.Users;
import com_xpu.domain.vo.UserVO;
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
}
