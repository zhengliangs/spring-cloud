package com.zfw.consumer.fegin;

import com.zfw.consumer.hystrix.ProviderFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * value 服务注册时的名称
 * spring.application.name
 */
@FeignClient(value = "provider", fallbackFactory = ProviderFallback.class)
public interface ProviderService {

    @GetMapping("/userController/getName")
    String getName(@RequestParam Integer id);

    /**
     * feign的负载均衡测试
     * 路由需要和服务提供者路由相同
     * @return
     */
    @GetMapping("/helloController/getRibbon")
    String getRibbon();

    /**
     * 服务熔断/降级
     * @return
     */
    @GetMapping(value = "/helloController/verifyHystrix")
    String verifyHystrix();


}
