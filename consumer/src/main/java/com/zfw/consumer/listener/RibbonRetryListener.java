//package com.zfw.consumer.listener;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.client.loadbalancer.LoadBalancedRetryContext;
//import org.springframework.retry.RetryCallback;
//import org.springframework.retry.RetryContext;
//import org.springframework.retry.RetryListener;
//
//import java.time.LocalDateTime;
//
///**
// * @author hero良
// * @Classname RibbonRetryListener
// * @description ribbon重试监听类
// * @Date 2019/9/12 10:46
// */
//@Slf4j
//public class RibbonRetryListener implements RetryListener {
//
//
//    @Override
//    public <T, E extends Throwable> boolean open(RetryContext retryContext, RetryCallback<T, E> retryCallback) {
//        log.info("=====open=====");
//        System.out.println("=====open=====");
//        return false;
//    }
//
//    @Override
//    public <T, E extends Throwable> void close(RetryContext retryContext, RetryCallback<T, E> retryCallback, Throwable throwable) {
//        System.out.println("=====close=====");
//        log.info("=====close=====");
//    }
//
//    @Override
//    public <T, E extends Throwable> void onError(RetryContext retryContext, RetryCallback<T, E> retryCallback, Throwable throwable) {
//        LocalDateTime now = LocalDateTime.now();
//        String service = ((LoadBalancedRetryContext) retryContext).getServiceInstance().getServiceId();
//        System.out.println(service + "微服务调用错误："+now.getMinute()+":"+now.getSecond()+"==="+throwable);
//        log.error(service + "微服务调用错误："+now.getMinute()+":"+now.getSecond()+"==="+throwable);
//    }
//}
