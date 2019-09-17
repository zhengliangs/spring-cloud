package com.zfw.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author hero良
 * @Classname RestTemplateService
 * @description 请求模板类
 * @Date 2019/9/16 15:30
 */
@Slf4j
@Service(value = "restTemplateService")
public class RestTemplateService {

    @Autowired
    private RestTemplate restTemplate;

    public String getTemplateRibbon(String name){
        return restTemplate.getForObject("http://provider/appController/getTemplateRibbon?name="+name, String.class);
    }

    public String getTemplateTimeout(String name){
        return restTemplate.getForObject("http://provider/appController/getTemplateTimeout?name="+name, String.class);
    }

    @HystrixCommand(fallbackMethod = "getHystrixFall")
    public String getHystrix(String name){
        return restTemplate.getForObject("http://provider/appController/getHystrix?name="+name, String.class);
    }

    String getHystrixFall(String name, Throwable t) {
        log.debug("name====" + name);
        log.error("getHystrix"+ t);
        return "this is hystrix getHystrix";
    }
}
