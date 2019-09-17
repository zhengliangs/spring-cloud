package com.zfw.consumer.service;

import com.zfw.consumer.fegin.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "appService")
public class AppService {

    @Autowired
    private ProviderService providerService;

    public String getName(Integer id) {
        return providerService.getName(id);
    }

    public String verifyHystrix() {
        return providerService.verifyHystrix();
    }
}
