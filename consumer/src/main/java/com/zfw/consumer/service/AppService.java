package com.zfw.consumer.service;

public interface AppService {

    String getName(Integer id);

    /**
     * @describe 负载均衡/默认轮询策略，
     * 可以在yml中配置负载均衡策略，服务名.ribbon.NFLoadBalancerRuleClassName 指定负载策略
     * @author: hero良
     * @param
     * @date: 2019/9/12 9:50
     * @return:
     */
    String getRibbon();

    /**
     * @describe 断路由/需要在yml开始断路由，feign.hystrix.enabled: true
     * @author: hero良
     * @param
     * @date: 2019/9/12 10:09
     * @return:
     */
    String verifyHystrix();
}
