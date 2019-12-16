package com.zfw.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Mono;

/**
 * 限流配置类
 * @author hero良
 * @className RateLimiterConfig
 * @description TODO
 * @date 2019/12/4
 */
@Configuration
public class RateLimiterConfig{

    @Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }

//    @Bean
//    @Primary//如果有多个限流策略需要标识以为主
//    KeyResolver apiKeyResolver() {
//        return exchange -> Mono.just(exchange.getRequest().getPath().value());
//    }
//
//    @Bean
//    public KeyResolver userKeyResolver() {
//        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"));
//    }
}
