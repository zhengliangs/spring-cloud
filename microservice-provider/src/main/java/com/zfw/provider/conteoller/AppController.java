package com.zfw.provider.conteoller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hero良
 * @className HelloController
 * @description TODO
 */
@Slf4j
@RestController
@RequestMapping("/appController")
public class AppController {

    /**
     * @description
     * @author hero良
     * @return java.lang.String
     * @exception
     * @version  1.0
     */
    @GetMapping("/getProductMsg")
    public String getProductMsg(){
        return "产品研发成功了！！！";
    }

    /**
     * @describe Ribbon负载均衡测试
     * @author: hero良
     * @param
     * @return:
     */
    @GetMapping("/getRibbonBalancer")
    public String getRibbonBalancer(String name){
        return "hello !" + name+" , this is 8765";
    }

    /**
     * @describe Ribbon超时重试测试
     * @author: hero良
     * @param
     * @return:
     */
    @GetMapping("/getRibbonTimeout")
    public String getRibbonTimeout(){
        log.info("************接受到请求*************");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello";
    }

    /**
     * @description Hystrix熔断降级测试
     * @author hero良
     * @param
     * @return
     */
    @GetMapping("/getRibbonHystrix")
    public String getRibbonHystrix(){
        log.info("************接受到请求*************");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello ,this is getRibbonHystrix";
    }



    /**********************************************************************************************************************************/


    /**
     * @describe Feign负载均衡测试
     * @author: hero良
     * @param
     * @return:
     */
    @GetMapping("/getFeignBalancer")
    public String getFeignBalancer(String name){
        return "hello " + name+" , this is 8764";
    }

    /**
     * @describe Feign超时重试测试
     * @author: hero良
     * @param
     * @return:
     */
    @GetMapping("/getFeignTimeout")
    public String getFeignTimeout(){
        log.info("************接受到请求*************");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello ";
    }

    /**
     * @description Hystrix熔断降级测试
     * @author hero良
     * @param
     * @return
     */
    @GetMapping("/getFeignHystrix")
    public String getFeignHystrix(){
        log.info("************接受到请求*************");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello ,this is getFeignHystrix";
    }
}
