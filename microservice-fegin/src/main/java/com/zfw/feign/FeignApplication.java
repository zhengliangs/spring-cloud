package com.zfw.feign;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//开启Eureka
@EnableEurekaClient
//开启Feign客户端注解
@EnableFeignClients
@SpringBootApplication
//@MapperScan("com.zfw.feign.mapper")
public class FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }

}
