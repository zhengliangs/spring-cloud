package com.zfw.consumer.controller;

import com.zfw.consumer.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hero良
 * @Classname RestTemplateController
 * @description TODO
 * @Date 2019/9/16 15:29
 */
@RestController
@RequestMapping("/ribbonController")
public class RibbonController {

    @Autowired
    private RibbonService ribbonService;

    @GetMapping("/getProductMsg")
    public String getProductMsg(){
        return ribbonService.getProductMsg();
    }


    /**
     * @description ribbon的负载均衡
     * @author hero良
     * @param name
     * @date 2019/9/17 21:52
     * @return java.lang.String
     * @exception
     * @version  1.0
     */
    @GetMapping("/getRibbonBalancer")
    public String getRibbonBalancer(String name){
        return ribbonService.getRibbonBalancer(name);
    }

    /**
     * @description ribbon的超时与重试
     * 超时需要在创建RestTemplate的时候指定时间，配置在配置文件中不生效，重试需要引入Spring-retry依赖
     * @author hero良
     * @param name
     * @date 2019/9/17 21:52
     * @return java.lang.String
     * @exception
     * @version  1.0
     */
    @GetMapping("/getRibbonTimeout")
    public String getRibbonTimeout(String name){
        return ribbonService.getRibbonTimeout(name);
    }

    /**
     * @description ribbon+hystrix
     * @author hero良
     * @param name
     * @date 2019/9/17 21:52
     * @return java.lang.String
     * @exception
     * @version  1.0
     */
    @GetMapping("/getRibbonHystrix")
    public String getRibbonHystrix(String name){
        return ribbonService.getRibbonHystrix(name);
    }
}
