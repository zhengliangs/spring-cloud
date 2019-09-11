package com.zfw.consumer.controller;

import com.zfw.consumer.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/appController")
public class AppController {

    @Autowired
    private AppService appService;

    @GetMapping(value = "/getName")
    public String getName(@RequestParam(value = "id") Integer id){
        return appService.getName(id);
    }

    /**
     * feign的负载均衡测试
     * @return
     */
    @GetMapping(value = "/getRibbon")
    public String getRibbon(){
        return appService.getRibbon();
    }

    /**
     *
     * @return
     */
    @GetMapping(value = "/verifyHystrix")
    public String verifyHystrix(){
        return appService.verifyHystrix();
    }
}
