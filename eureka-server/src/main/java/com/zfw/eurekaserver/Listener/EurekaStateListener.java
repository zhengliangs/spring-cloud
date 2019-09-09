package com.zfw.eurekaserver.Listener;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EurekaStateListener {

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        System.out.println("服务{}进行注册"+instanceInfo.getAppName()+ instanceInfo.getHostName() +"  "+ instanceInfo.getIPAddr() +"  "+ instanceInfo.getPort());
    }

    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        System.out.println("服务{}已下线"+event.getAppName());
        System.out.println("server地址信息{}"+event.getServerId());
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        System.out.println( "服务{}进行续约"+event.getServerId() +"  "+ event.getAppName());
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
//        logger.info("注册中心启动,{}", System.currentTimeMillis());
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
//        logger.info("注册中心服务端启动,{}", System.currentTimeMillis());
    }

}
