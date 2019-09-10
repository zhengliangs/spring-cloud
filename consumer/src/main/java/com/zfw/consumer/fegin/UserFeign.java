package com.zfw.consumer.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * value 服务注册时的名称
 * spring.application.name
 */
@FeignClient(value = "provider")
public interface UserFeign {

    @GetMapping("/userController/getName")
    String getName(@RequestParam Integer id);

    /**
     * feign的负载均衡测试
     * @return
     */
    @GetMapping("/userController/getFeign")
    String getFeign();


}
