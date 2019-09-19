package com.zfw.consumer.Hystrix;

import com.zfw.consumer.fegin.FeignClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author hero良
 * @className FeignHystrix
 * @description TODO
 * @date 2019/9/18
 */
@Component
public class FeignHystrix implements FallbackFactory<FeignClientService> {

    @Override
    public FeignClientService create(Throwable throwable) {
        return new FeignClientService() {
            @Override
            public String getFeignBalancer(String name) {
                return "进入hystrix的getFeignBalancer";
            }

            @Override
            public String getFeignTimeout(String name) {
                return "进入hystrix的getFeignTimeout";
            }

            @Override
            public String getFeignHystrix(String name) {
                return "进入hystrix的getFeignHystrix";
            }
        };
    }
}
