package com.zfw.feign.fegin;

import com.zfw.feign.hystrix.FallbackFactoryHystrix;
import com.zfw.feign.hystrix.FallbackHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "feignClientService", serviceId = "provider-service", /**fallbackFactory = FallbackFactoryHystrix.class*/fallback = FallbackHystrix.class)
public interface FeignClientService {

    @GetMapping("/appController/getFeignBalancer")
    String getFeignBalancer(@RequestParam(value = "name") String name);

    @GetMapping("/appController/getFeignTimeout")
    String getFeignTimeout();

    @GetMapping("/appController/getFeignHystrix")
    String getFeignHystrix();
}
