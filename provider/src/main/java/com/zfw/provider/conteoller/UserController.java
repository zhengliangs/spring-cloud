package com.zfw.provider.conteoller;

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

    @GetMapping(value = "getName")
    public String getName(Integer id){
        System.out.println("id==="+id);
        return "张三";
    }
}
