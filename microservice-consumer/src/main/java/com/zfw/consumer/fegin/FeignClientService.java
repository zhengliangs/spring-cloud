package com.zfw.consumer.fegin;

import com.zfw.consumer.hystrix.FeignHystrix;
import com.zfw.consumer.hystrix.FeignHystrixConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "provider", /**fallback = HystrixClientFallback.class**/ fallbackFactory = FeignHystrix.class, configuration = FeignHystrixConfiguration.class)
public interface FeignClientService {

    @GetMapping("/appController/getFeignBalancer")
    String getFeignBalancer(@PathVariable(value = "name") String name);

    @GetMapping("/appController/getFeignTimeout")
    String getFeignTimeout();

    @GetMapping("/appController/getFeignHystrix")
    String getFeignHystrix(@PathVariable(value = "name") String name);
}
