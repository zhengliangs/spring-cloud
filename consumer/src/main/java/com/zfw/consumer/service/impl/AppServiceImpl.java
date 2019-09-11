package com.zfw.consumer.service.impl;

import com.zfw.consumer.fegin.ProviderService;
import com.zfw.consumer.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "appService")
public class AppServiceImpl implements AppService {

    @Autowired
    private ProviderService providerService;

    @Override
    public String getName(Integer id) {
        return providerService.getName(id);
    }

    @Override
    public String getRibbon() {
        return providerService.getRibbon();
    }

    @Override
    public String verifyHystrix() {
        return providerService.verifyHystrix();
    }
}
