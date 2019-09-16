package com.zfw.consumer.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author hero良
 * @Classname RestTemplateService
 * @description 请求模板类
 * @Date 2019/9/16 15:30
 */
@Service(value = "restTemplateService")
public class RestTemplateService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand
    public String getTemplate(String name){
        return restTemplate.getForObject("http://provider/appController/getTemplateRibbon?name="+name, String.class);
    }

    public String getTemplateTimeout(String name){
        return restTemplate.getForObject("http://provider/appController/getTemplateTimeout?name="+name, String.class);
    }
}
