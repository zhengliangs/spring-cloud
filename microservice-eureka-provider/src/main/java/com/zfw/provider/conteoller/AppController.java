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
     * @describe 测试RestTemplate+Ribbon负载均衡
     * @author: hero良
     * @param
     * @date: 2019/9/16 16:25
     * @return:
     */
    @GetMapping("/getTemplateRibbon")
    public String getTemplate(String name){
        log.debug("************接受到请求*************");
        return "this is 8763， hello " + name;
    }

    /**
     * @describe 测试RestTemplate熔断
     * @author: hero良
     * @param
     * @date: 2019/9/16 16:26
     * @return: 
     */
    @GetMapping("/getTemplateTimeout")
    public String getTemplateTimeout(String name){
        log.debug("************接受到请求*************");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello " + name;
    }

    /**
    * @description 负载均衡测试
    * 使用application来启动两个不同的port,返回不同的端口号（8763和8764）
    * @author hero良
    * @date 2019/9/14 21:57
    * @return java.lang.String
    * @version  1.0
    */
    @GetMapping(value = "/getRibbon")
    public String getRibbon(){
        log.debug("请求进入");
        return "hi ribbon, from port 8763";
    }

    @GetMapping(value = "/verifyHystrix")
    public String verifyHystrix(){
        log.debug("******接收到请求******");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.error("verifyHystrix", e);
        }
        return "hello verifyHystrix";
    }
}
