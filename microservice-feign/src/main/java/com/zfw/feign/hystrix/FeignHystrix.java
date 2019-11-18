package com.zfw.feign.hystrix;

import com.zfw.feign.fegin.FeignClientService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author hero良
 * @className FeignHystrix
 * @description TODO
 * @date 2019/9/18
 */
@Slf4j
@Component
public class FeignHystrix implements FallbackFactory<FeignClientService> {

    @Override
    public FeignClientService create(Throwable throwable) {
        //打印日志
        log.error("fallback; throwable was: " + throwable.getMessage());

        return new FeignClientService() {
            @Override
            public String getFeignBalancer(String name) {
                return "进入hystrix的getFeignBalancer";
            }

            @Override
            public String getFeignTimeout() {
                return "进入hystrix的getFeignTimeout";
            }

            @Override
            public String getFeignHystrix(String name) {
                return "进入hystrix的getFeignHystrix";
            }
        };
    }
}
