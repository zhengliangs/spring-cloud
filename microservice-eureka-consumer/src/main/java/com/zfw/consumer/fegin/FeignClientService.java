package com.zfw.consumer.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "provider")
public interface FeignClientService {

    @GetMapping("/appController/getFeignBalancer")
    String getFeignBalancer(@RequestParam(value = "name") String name);

    @GetMapping("/appController/getFeignTimeout")
    String getFeignTimeout(@RequestParam(value = "name") String name);
}
