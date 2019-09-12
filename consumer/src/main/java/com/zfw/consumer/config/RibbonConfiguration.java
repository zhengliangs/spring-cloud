package com.zfw.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalancedRetryFactory;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hero良
 * @Classname RibbonConfiguration
 * @description ribbon配置类
 * @Date 2019/9/12 10:36
 */
@Configuration
public class RibbonConfiguration {

//    @Bean
//    public LoadBalancedRetryFactory loadBalancedRetryPolicyFactory(final SpringClientFactory clientFactory){
//        return new DefaultRibbonLoadBalanceRetryFactory(clientFactory);
//    }
}
