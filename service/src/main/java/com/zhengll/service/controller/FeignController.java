package com.zhengll.service.controller;

import com.zhengll.service.fegin.FeignClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hero良
 * @className FeignController
 */
@RestController
public class FeignController {

    @Autowired
    private FeignClientService feignClientService;

    /**
     * @description feign的负载均衡
     * @author hero良
     */
    @GetMapping("/feignBalancer")
    public String feignBalancer(String name){
        if("Java".equals(name)){
            throw new RuntimeException();
        }
        return feignClientService.feignBalancer(name);
    }

    /**
     * @description feign的超时与重试
     * @author hero良
     */
    @GetMapping("/feignTimeout")
    public String feignTimeout(){
        return feignClientService.feignTimeout();
    }

    /**
     * @description feign+hystrix
     * @author hero良
     */
    @GetMapping("/feignHystrix")
    public String feignHystrix(){
        return feignClientService.feignHystrix();
    }
}
