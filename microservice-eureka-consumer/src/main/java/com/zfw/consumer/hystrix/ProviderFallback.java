package com.zfw.consumer.hystrix;

import com.zfw.consumer.fegin.ProviderService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author hero良
 * @Classname UserHystrix
 * @description TODO
 * @Date 2019/9/11 14:26
 */
@Slf4j
@Component
public class ProviderFallback implements FallbackFactory<ProviderService> {

    @Override
    public ProviderService create(Throwable throwable) {
        return new ProviderService() {
            @Override
            public String getName(Integer id) {
                return "this is hystrix getName" + id;
            }

            @Override
            public String getRibbon() {
                return "this is hystrix getRibbon";
            }

            @Override
            public String verifyHystrix() {
                log.info("进入服务熔断");
                return "this is hystrix verifyHystrix";
            }
        };
    }
}
