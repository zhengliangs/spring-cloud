package com.zfw.eurekaserver.Listener;

import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class EurekaStateListener {

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        log.info("****服务进行注册****", instanceInfo.getAppName()+ instanceInfo.getHostName() +"  "+ instanceInfo.getIPAddr() +"  "+ instanceInfo.getPort());
    }

    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        log.info("****服务已下线****", event.getAppName(), event.getServerId());
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        LocalDateTime now = LocalDateTime.now();
        log.info( "****服务进行续约****"+now.getHour()+":"+now.getMinute()+":"+now.getSecond()+event.getAppName()+event.getServerId());
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        log.info("****注册中心启动****", System.currentTimeMillis());
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        log.info("****注册中心服务端启动****", System.currentTimeMillis());
    }

}
