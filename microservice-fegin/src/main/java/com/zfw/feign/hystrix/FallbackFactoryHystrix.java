package com.zfw.feign.hystrix;

import com.zfw.feign.fegin.FeignClientService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author hero良
 * @className FallbackFactoryHystrix
 * @description TODO
 */
@Slf4j
@Component
public class FallbackFactoryHystrix implements FallbackFactory<FeignClientService> {

    @Override
    public FeignClientService create(Throwable throwable) {

        log.error("fallback; throwable was: " + throwable.getMessage());

        return new FeignClientService() {
            @Override
            public String getFeignBalancer(String name) {
                return "这里是回退 getFeignBalancer";
            }

            @Override
            public String getFeignTimeout() {
                return "这里是回退 getFeignTimeout";
            }

            @Override
            public String getFeignHystrix() {
                return "这里是回退 getFeignHystrix";
            }
        };
    }
}
