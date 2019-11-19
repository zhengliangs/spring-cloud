package com.zfw.feign.hystrix;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 配置禁用hystrix的feign
 * @author hero良
 * @className FeignHystrixConfiguration
 * @description
 */
@Configuration
public class FeignHystrixConfiguration {

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }
}
