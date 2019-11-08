package com.zfw.consumer.service;

//import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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

//    @Autowired
//    LoadBalancerClient loadBalancerClient;

    public String getProductMsg(){
        //第一种  直接写死url
//        String result = restTemplate.getForObject("http://localhost:8764/appController/getProductMsg", String.class);

        //第二种  使用LoadBalancerClient获取url
        //1.@LoadBalanced 不加此注解，服务提供者  instance.prefer-ip-address: true 或者不配置都可以
        //2.加上@LoadBalanced，服务提供者prefer-ip-address: 为true或者false都会提示找不到可用实例，需要使用getServiceId():port进行调用
//        ServiceInstance provider = loadBalancerClient.choose("PROVIDER");
//        String url = String.format("http://%s:%s",provider.getHost(),provider.getPort())+"/appController/getProductMsg";
//        String url = String.format("http://%s:%s",provider.getServiceId(),provider.getPort())+"/appController/getProductMsg";
//        String result = restTemplate.getForObject(url, String.class);

        //第三种  直接指定服务名
        String result = restTemplate.getForObject("http://PROVIDER/appController/getProductMsg",String.class);
        return result;
    }

    public String getRibbonBalancer(String name){
        return restTemplate.getForObject("http://provider/appController/getRibbonBalancer?name="+name, String.class);
    }

    public String getRibbonTimeout(){
        return restTemplate.getForObject("http://provider/appController/getRibbonTimeout", String.class);
    }

//    @HystrixCommand
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
    String getHystrixFall() {
        return "this is fallbackMethod getRibbonHystrix";
    }
}
