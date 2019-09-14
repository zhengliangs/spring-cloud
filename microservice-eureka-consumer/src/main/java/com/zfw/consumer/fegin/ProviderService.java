package com.zfw.consumer.fegin;

import com.zfw.consumer.hystrix.ProviderFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @describe feign接口类
 * value为注册中心serviceId,路由地址要和服务提供者一致
 * @author: hero良
 * @date: 2019/9/12 9:58
 */
@FeignClient(value = "provider", fallbackFactory = ProviderFallback.class)
public interface ProviderService {

    @GetMapping("/userController/getName")
    String getName(@RequestParam Integer id);

    /**
     * @describe 负载均衡feign
     * @author: hero良
     * @param
     * @date: 2019/9/12 9:58
     * @return:
     */
    @GetMapping("/helloController/getRibbon")
    String getRibbon();

    /**
     * @describe 服务熔断/降级hystrix
     * @author: hero良
     * @param
     * @date: 2019/9/12 9:58
     * @return:
     */
    @GetMapping(value = "/helloController/verifyHystrix")
    String verifyHystrix();


}
