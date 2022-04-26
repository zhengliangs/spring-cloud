package com.zhengll.service.hystrix;

import com.zhengll.service.fegin.FeignClientService;
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
    public String feignBalancer(String name) {
        return "fail";
    }

    @Override
    public String feignTimeout() {
        return "fail";
    }

    @Override
    public String feignHystrix() {
        return "fail";
    }
}
