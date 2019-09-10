package com.zfw.provider.conteoller;

import com.zfw.provider.entity.JacksonEntity;
import com.zfw.provider.service.JacksonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hero良
 * @className AppController
 * @description TODO
 * @date 2019/9/10
 */
@RestController
@RequestMapping("/appController")
@Slf4j
public class AppController {

    @Autowired
    private JacksonService jacksonService;

    @GetMapping("/getJacksonInfo")
    public JacksonEntity getJacksonInfo(){
        return jacksonService.getJacksonInfo();
    }
}
