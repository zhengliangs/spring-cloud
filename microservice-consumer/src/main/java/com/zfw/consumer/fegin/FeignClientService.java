package com.zfw.consumer.fegin;

import com.zfw.consumer.hystrix.FeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "provider", fallbackFactory = FeignHystrix.class)
public interface FeignClientService {

    @GetMapping("/appController/getFeignBalancer")
    String getFeignBalancer(@RequestParam(value = "name") String name);

    @GetMapping("/appController/getFeignTimeout")
    String getFeignTimeout();

    @GetMapping("/appController/getFeignHystrix")
    String getFeignHystrix(@RequestParam(value = "name") String name);
}
