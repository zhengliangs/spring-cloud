package com.zfw.consumer.controller;

import com.zfw.consumer.service.impl.AppService;
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
     * @describe 负载均衡/默认轮询策略，
     * 可以在yml中配置负载均衡策略，服务名.ribbon.NFLoadBalancerRuleClassName 指定负载策略
     * @author: hero良
     * @param
     * @date: 2019/9/12 9:50
     * @return:
     */
    @GetMapping(value = "/getRibbon")
    public String getRibbon(){
        return appService.getRibbon();
    }

    /**
     * @describe 断路由/需要在yml开始断路由，feign.hystrix.enabled: true
     * @author: hero良
     * @param
     * @date: 2019/9/12 10:09
     * @return: 
     */
    @GetMapping(value = "/verifyHystrix")
    public String verifyHystrix(){
        return appService.verifyHystrix();
    }
}
