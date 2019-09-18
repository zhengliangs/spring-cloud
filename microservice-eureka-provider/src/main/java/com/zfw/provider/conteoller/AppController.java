package com.zfw.provider.conteoller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hero良
 * @className HelloController
 * @description TODO
 * @date 2019/9/10
 */
@Slf4j
@RestController
@RequestMapping("/appController")
public class AppController {

    /**
     * @describe Ribbon负载均衡测试
     * @author: hero良
     * @param
     * @date: 2019/9/16 16:25
     * @return:
     */
    @GetMapping("/getRibbonBalancer")
    public String getRibbonBalancer(String name){
        log.debug("************接受到请求*************");
        return "hello " + name+" , this is 8764";
    }

    /**
     * @describe Ribbon超时测试
     * @author: hero良
     * @param
     * @date: 2019/9/16 16:26
     * @return: 
     */
    @GetMapping("/getRibbonTimeout")
    public String getRibbonTimeout(String name){
        log.debug("************接受到请求*************");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello " + name;
    }

    /**
     * @description Hystrix熔断降级测试
     * @author hero良
     * @param
     * @date 2019/9/17 11:40
     * @return
     */
    @GetMapping("/getRibbonHystrix")
    public String getRibbonHystrix(String name){
        log.debug("************接受到请求*************");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello " + name + " ,this is getRibbonHystrix";
    }

    /**
     * @describe Feign负载均衡测试
     * @author: hero良
     * @param
     * @date: 2019/9/16 16:25
     * @return:
     */
    @GetMapping("/getFeignBalancer")
    public String getFeignBalancer(String name){
        log.debug("************接受到请求*************");
        return "hello " + name+" , this is 8764";
    }

    /**
     * @describe Feign超时测试
     * @author: hero良
     * @param
     * @date: 2019/9/16 16:26
     * @return:
     */
    @GetMapping("/getFeignTimeout")
    public String getFeignTimeout(String name){
        log.debug("************接受到请求*************");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello " + name;
    }

    /**
     * @description Hystrix熔断降级测试
     * @author hero良
     * @param
     * @date 2019/9/17 11:40
     * @return
     */
    @GetMapping("/getFeignHystrix")
    public String getFeignHystrix(String name){
        log.debug("************接受到请求*************");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello " + name + " ,this is getFeignHystrix";
    }
}
