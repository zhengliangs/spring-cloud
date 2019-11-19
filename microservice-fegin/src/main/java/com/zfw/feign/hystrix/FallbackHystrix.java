package com.zfw.feign.hystrix;

import com.zfw.feign.fegin.FeignClientService;
import org.springframework.stereotype.Component;

/**
 * 这个类不一定要和FeignClientService写在同一个类中
 * @author hero良
 * @className FallbackHystrix
 * @description
 */
@Component
public class FallbackHystrix implements FeignClientService {

    @Override
    public String getFeignBalancer(String name) {
        return null;
    }

    @Override
    public String getFeignTimeout() {
        return null;
    }

    @Override
    public String getFeignHystrix() {
        return "出错了";
    }
}
