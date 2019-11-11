package com.zfw.consumer.hystrix;

import com.zfw.consumer.fegin.FeignClientService;

/**
 * 这个类不一定要和FeignClientService写在同一个类中
 * @author hero良
 * @className HystrixClientFallback
 * @description
 * @date 2019/11/11 9:47
 */
public class HystrixClientFallback implements FeignClientService {

    @Override
    public String getFeignBalancer(String name) {
        return null;
    }

    @Override
    public String getFeignTimeout() {
        return null;
    }

    @Override
    public String getFeignHystrix(String name) {
        return "出错了";
    }
}
