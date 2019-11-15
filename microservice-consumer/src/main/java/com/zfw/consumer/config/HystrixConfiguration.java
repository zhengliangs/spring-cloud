package com.zfw.consumer.config;

//import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hero良
 * @className HystrixConfiguration
 * @description
 * @date 2019/11/15 11:04
 */
@Configuration
public class HystrixConfiguration {
//    @Bean
//    public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet(){
//        HystrixMetricsStreamServlet hystrixMetricsStreamServlet = new HystrixMetricsStreamServlet();
//        ServletRegistrationBean<HystrixMetricsStreamServlet> servletRegistrationBean = new ServletRegistrationBean();
//        servletRegistrationBean.setServlet(hystrixMetricsStreamServlet);
//        servletRegistrationBean.addUrlMappings("/hystrix.stream");
//        servletRegistrationBean.setName("HystrixMetricsStreamServlet");
//        return servletRegistrationBean;
//    }
}
