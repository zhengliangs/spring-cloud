package com.zfw.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author hero良
 * @classname RestTemplateConfiguration
 * @description restTemplate配置类
 * @date 2019/9/16 15:21
 */
@Configuration
public class RestTemplateConfiguration {

    /**
     * @description
     * @author hero良
     * @param
     * @date 2019/9/16 15:22
     * @return
     */
    @Bean
    @LoadBalanced //启用负载均衡
    public RestTemplate restTemplate(){
        //配置超时
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectTimeout(500);
        httpRequestFactory.setReadTimeout(2000);
        return new RestTemplate(httpRequestFactory);
    }
}
