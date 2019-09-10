package com.zfw.consumer.controller;

import com.zfw.consumer.fegin.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/appController")
public class AppController {

    @Autowired
    private UserFeign userFeign;

    @GetMapping(value = "/getName")
    public String getName(@RequestParam(value = "id") Integer id){
        return userFeign.getName(id);
    }

    /**
     * feign的负载均衡测试
     * @return
     */
    @GetMapping(value = "/getFeign")
    public String getFeign(){
        return userFeign.getFeign();
    }
}
