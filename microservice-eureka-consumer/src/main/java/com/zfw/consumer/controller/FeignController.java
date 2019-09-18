package com.zfw.consumer.controller;

import com.zfw.consumer.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hero良
 * @classname FeignController
 * @description TODO
 * @date 2019/9/18 17:29
 */
@RestController
@RequestMapping("/feignController")
public class FeignController {

    @Autowired
    private FeignService feignService;

    /**
     * @description feign的负载均衡
     * @author hero良
     * @param name
     * @date 2019/9/17 21:52
     * @return java.lang.String
     * @exception
     * @version  1.0
     */
    @GetMapping("/getFeignBalancer")
    public String getFeignBalancer(String name){
        return feignService.getFeignBalancer(name);
    }

    /**
     * @description feign的超时与重试
     * 超时需要在创建RestTemplate的时候指定时间，配置在配置文件中不生效，重试需要引入Spring-retry依赖
     * @author hero良
     * @param name
     * @date 2019/9/17 21:52
     * @return java.lang.String
     * @exception
     * @version  1.0
     */
    @GetMapping("/getFeignTimeout")
    public String getFeignTimeout(String name){
        return feignService.getFeignTimeout(name);
    }
}
