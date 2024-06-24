package com_xpu.service.impl.adapter;

import com_xpu.common.enums.UsersStatus;
import com_xpu.domain.entity.Users;
import com_xpu.domain.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 将UserVO封装为User
 */
@Component
public class UserAdapter {


    //注册数据封装
    public Users returnUser(UserDTO userDTO) {
        String uuid = UUID.randomUUID().toString();

        Users users = Users.builder()
                .phone(userDTO.getPhone())
                .password(userDTO.getPassword())
                .username(userDTO.getUsername())
                .userId(uuid)
                .status(UsersStatus.CREATED)
                .build();
        return users;

    }
}
