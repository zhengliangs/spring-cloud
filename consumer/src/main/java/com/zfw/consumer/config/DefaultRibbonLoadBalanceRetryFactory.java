//package com.zfw.consumer.config;
//
//import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancedRetryFactory;
//import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
//
///**
// * @author hero良
// * @Classname DefaultRibbonLoadBalanceRetryFactory
// * @description TODO
// * @Date 2019/9/12 10:39
// */
//public class DefaultRibbonLoadBalanceRetryFactory extends RibbonLoadBalancedRetryFactory {
//
//    public DefaultRibbonLoadBalanceRetryFactory(SpringClientFactory clientFactory) {
//        super(clientFactory);
//    }
//
//    @Override
//    public org.springframework.retry.RetryListener[] createRetryListeners(String service) {
//        return super.createRetryListeners(service);
//    }
//}
