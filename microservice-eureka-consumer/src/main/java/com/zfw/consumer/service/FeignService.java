package com.zfw.consumer.service;

import com.zfw.consumer.fegin.FeignClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hero良
 * @classname FeignService
 * @description TODO
 * @date 2019/9/18 17:08
 */
@Service(value = "feignService")
public class FeignService {

    @Autowired
    private FeignClientService feignClientService;

    public String getFeignBalancer(String name){
        return feignClientService.getFeignBalancer(name);
    }

    public String getFeignTimeout(String name){
        return feignClientService.getFeignTimeout(name);
    }

    public String getFeignHystrix(String name){
        return feignClientService.getFeignHystrix(name);
    }
}
