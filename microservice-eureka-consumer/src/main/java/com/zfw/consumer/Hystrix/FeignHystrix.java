package com.zfw.consumer.Hystrix;

import com.zfw.consumer.fegin.FeignClientService;
import feign.hystrix.FallbackFactory;

/**
 * @author hero良
 * @className FeignHystrix
 * @description TODO
 * @date 2019/9/18
 */
public class FeignHystrix implements FallbackFactory<FeignClientService> {


    @Override
    public FeignClientService create(Throwable throwable) {
        return null;
    }
}
