package com.zfw.feign.controller;

import com.zfw.feign.fegin.FeignClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hero良
 * @classname FeignController
 * @description TODO
 */
@RestController
public class FeignController {

    @Autowired
    private FeignClientService feignClientService;

    /**
     * @description feign的负载均衡
     * @author hero良
     * @param name
     * @return java.lang.String
     * @exception
     * @version  1.0
     */
    @GetMapping("/getFeignBalancer")
    public String getFeignBalancer(String name){
        return feignClientService.getFeignBalancer(name);
    }

    /**
     * @description feign的超时与重试
     * @author hero良
     * @return java.lang.String
     * @exception
     * @version  1.0
     */
    @GetMapping("/getFeignTimeout")
    public String getFeignTimeout(){
        return feignClientService.getFeignTimeout();
    }

    /**
     * @description feign+hystrix
     * @author hero良
     * @return java.lang.String
     * @exception
     * @version  1.0
     */
    @GetMapping("/getFeignHystrix")
    public String getFeignHystrix(){
        return feignClientService.getFeignHystrix();
    }
}
