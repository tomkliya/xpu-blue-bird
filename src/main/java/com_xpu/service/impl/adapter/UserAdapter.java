package com_xpu.service.impl.adapter;

import com_xpu.common.enums.UsersStatus;
import com_xpu.domain.entity.Users;
import com_xpu.domain.vo.UserVO;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 将UserVO封装为User
 */
@Component
public class UserAdapter {
    public Users returnUser(UserVO userVO) {
        String uuid = UUID.randomUUID().toString();
        Users users = Users.builder()
                .phone(userVO.getPhone())
                .password(userVO.getPassword())
                .username(userVO.getUsername())
                .userId(uuid)
                .status(UsersStatus.CREATED)
                .build();
        return users;

    }
}
