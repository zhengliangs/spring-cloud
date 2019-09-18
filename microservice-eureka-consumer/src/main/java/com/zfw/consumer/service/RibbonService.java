package com.zfw.consumer.service;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author hero良
 * @Classname RibbonService
 * @description 请求模板类
 * @Date 2019/9/16 15:30
 */
@Slf4j
@Service(value = "ribbonService")
public class RibbonService {

    @Autowired
    private RestTemplate restTemplate;

    public String getRibbonBalancer(String name){
        return restTemplate.getForObject("http://provider/appController/getRibbonBalancer?name="+name, String.class);
    }

    public String getRibbonTimeout(String name){
        return restTemplate.getForObject("http://provider/appController/getRibbonTimeout?name="+name, String.class);
    }

//    @HystrixCommand(fallbackMethod = "getHystrixFall")
    public String getRibbonHystrix(String name){
        return restTemplate.getForObject("http://provider/appController/getRibbonHystrix?name="+name, String.class);
    }

    /**
     * @description 降级回退
     * @author hero良
     * @param
     * @date 2019/9/18 16:54
     * @return 
     */
    String getHystrixFall(String name, Throwable t) {
        log.debug("name====" + name + "    t===="+t);
        return "this is fallbackMethod getRibbonHystrix";
    }
}
