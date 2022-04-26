package com.zhengll.service.fegin;

import com.zhengll.service.hystrix.FallbackHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service1-server", fallback = FallbackHystrix.class)
public interface FeignClientService {

    @GetMapping("/appController/feignBalancer")
    String feignBalancer(@RequestParam(value = "name") String name);

    @GetMapping("/appController/feignTimeout")
    String feignTimeout();

    @GetMapping("/appController/feignHystrix")
    String feignHystrix();
}
