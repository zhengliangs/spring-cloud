package com.zfw.provider.service;

import com.zfw.provider.entity.PropertiesEntity;
import com.zfw.provider.entity.UserEntity;

public interface UserService {


    UserEntity getUserInfo();

    /**
     * 注入配置文件测试
     * @return
     */
    PropertiesEntity getPropertiesEntity();
}
