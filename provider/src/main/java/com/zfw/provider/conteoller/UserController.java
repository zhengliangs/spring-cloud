package com.zfw.provider.conteoller;

import com.zfw.provider.entity.PropertiesEntity;
import com.zfw.provider.entity.UserEntity;
import com.zfw.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userController")
public class UserController {

    @Autowired
    public UserService userService;


    @GetMapping(value = "/getUserInfo")
    public UserEntity getUserInfo(){
        return userService.getUserInfo();
    }

    /**
     * 声明式feign调用测试
     * @param id
     * @return
     */
    @GetMapping(value = "/getName")
    public String getName(Integer id){
        return "张三"+id;
    }

    /**
     * 注入配置文件测试
     * @return
     */
    @GetMapping(value = "/get")
    public PropertiesEntity get() {
        return userService.getPropertiesEntity();
    }

}
