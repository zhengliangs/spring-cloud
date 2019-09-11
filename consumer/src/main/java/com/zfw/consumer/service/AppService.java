package com.zfw.consumer.service;

public interface AppService {

    String getName(Integer id);

    /**
     * feign的负载均衡测试
     * 路由需要和服务提供者路由相同
     * @return
     */
    String getRibbon();

    /**
     * 服务熔断/降级
     * @return
     */
    String verifyHystrix();
}
