package com.zhengll.service.conteoller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hero良
 * @className HelloController
 * @description TODO
 */
@Slf4j
@RestController
@RequestMapping("/appController")
public class AppController {

    @Value("${server.port}")
    private int port;

    /**
     * @description 负载均衡测试
     * @author: hero良
     */
    @GetMapping("/feignBalancer")
    public String feignBalancer(String name){
        return "feignBalancer!! name = " + name + ", port = {}" + port;
    }

    /**
     * @description 超时重试测试
     * @author: hero良
     */
    @GetMapping("/feignTimeout")
    public String feignTimeout(){
        log.info("************接受到请求*************");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
        return "feignTimeout!!";
    }

    /**
     * @description 熔断降级测试
     * @author hero良
     */
    @GetMapping("/feignHystrix")
    public String feignHystrix(){
        log.info("************接受到请求*************");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
        return "feignHystrix!!";
    }
}
