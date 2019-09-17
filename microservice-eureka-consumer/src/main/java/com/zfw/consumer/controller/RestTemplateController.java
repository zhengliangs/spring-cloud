package com.zfw.consumer.controller;

import com.zfw.consumer.service.RestTemplateService;
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
@RequestMapping("/restTemplateController")
public class RestTemplateController {

    @Autowired
    private RestTemplateService restTemplateService;

    @GetMapping("/getTemplateRibbon")
    public String getTemplate(String name){
        return restTemplateService.getTemplateRibbon(name);
    }

    @GetMapping("/getTemplateTimeout")
    public String getTemplateTimeout(String name){
        return restTemplateService.getTemplateTimeout(name);
    }

    @GetMapping("/getHystrix")
    public String getHystrix(String name){
        return restTemplateService.getHystrix(name);
    }
}
