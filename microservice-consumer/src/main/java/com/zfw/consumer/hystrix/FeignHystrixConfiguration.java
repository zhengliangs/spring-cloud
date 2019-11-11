package com.zfw.consumer.hystrix;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 配置禁用hystrix的feign
 * @author hero良
 * @className FeignHystrixConfiguration
 * @description
 * @date 2019/11/11 10:09
 */
@Configuration
public class FeignHystrixConfiguration {

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }
}
