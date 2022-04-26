package com.zhengll.service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Name;
import java.util.Map;

/**
 * @author hero良
 * @className GatewayController
 * @date 2019/12/13 17:04
 */
@Slf4j
@RestController
public class GatewayController {

    @GetMapping("/getInfo")
    public String getInfo(String name){
        return "hello! " + name;
    }

    /**
     * 熔断降级
     */
    @GetMapping("/fusing")
    public String fusing(String name){
        log.info("############### in fusing = {}", name);
        try {
            Thread.sleep(6000);
        }catch (InterruptedException e){
            log.error(e.getMessage(), e);
        }
        return " fusing! " + name;
    }

    /**
     * 限流
     */
    @GetMapping("/rateLimiter")
    public String rateLimiter(){
        log.info("############### in rateLimiter ");
        return " rateLimiter!";
    }

    /**
     * 重试
     */
    @GetMapping("/retry")
    public String retry(@RequestParam Integer param){
        log.info("############### in retry = {}", param);
        if(param == 1){
            throw new RuntimeException("error");
        }
        return " retry! ";
    }

    /**
     * 获取Post请求体
     */
    @PostMapping("/getPostBody")
    public String getPostBody(@RequestParam Map<String, String> request){
        return " getPostBody   " + request.get("name") + ", 欢迎来到Java";
    }

}
