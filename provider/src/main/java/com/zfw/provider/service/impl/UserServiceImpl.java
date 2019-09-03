package com.zfw.provider.service.impl;

import com.zfw.provider.entity.UserEntity;
import com.zfw.provider.service.UserService;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Override
    public UserEntity getUserInfo() {

        return new UserEntity(1, "张三", 22, 1);
    }
}
