package com.zfw.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.NettyDataBufferFactory;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 全局过滤器
 * 所有请求都会执行
 * 可拦截get、post等请求做逻辑处理
 * @author hero良
 * @className RequestGlobalFilter
 * @description
 *
 * @date 2019/11/29 16:28
 */
@Slf4j
@Component
public class RequestGlobalFilter implements GlobalFilter, Ordered {


    //执行逻辑
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest serverHttpRequest= exchange.getRequest();
        String uriPath = serverHttpRequest.getURI().toString();
        log.info(" uriPath : " + uriPath);//打印每次请求的url
        String method = serverHttpRequest.getMethodValue();
        if ("POST".equals(method)) {
            //从请求里获取Post请求体
            String bodyStr = resolveBodyFromRequest(serverHttpRequest);
            //TODO 得到Post请求的请求参数后，做你想做的事

            //下面的将请求体再次封装写回到request里，传到下一级，否则，由于请求体已被消费，后续的服务将取不到值
            URI uri = serverHttpRequest.getURI();
            ServerHttpRequest request = serverHttpRequest.mutate().uri(uri).build();
            DataBuffer bodyDataBuffer = stringBuffer(bodyStr);
            Flux<DataBuffer> bodyFlux = Flux.just(bodyDataBuffer);

            request = new ServerHttpRequestDecorator(request) {
                @Override
                public Flux<DataBuffer> getBody() {
                    return bodyFlux;
                }
            };
            //封装request，传给下一级
            return chain.filter(exchange.mutate().request(request).build());
        } else if ("GET".equals(method)) {
            Map requestQueryParams = serverHttpRequest.getQueryParams();
            //TODO 得到Get请求的请求参数后，做你想做的事

            return chain.filter(exchange);
        }
        return chain.filter(exchange);
    }

    /**
     * 从Flux<DataBuffer>中获取字符串的方法
     * @return 请求体
     */
    private String resolveBodyFromRequest(ServerHttpRequest serverHttpRequest) {
        //获取请求体
        Flux<DataBuffer> body = serverHttpRequest.getBody();

        AtomicReference<String> bodyRef = new AtomicReference<>();
        body.subscribe(buffer -> {
            CharBuffer charBuffer = StandardCharsets.UTF_8.decode(buffer.asByteBuffer());
            DataBufferUtils.release(buffer);
            bodyRef.set(charBuffer.toString());
        });
        //获取request body
        return bodyRef.get();
    }

    private DataBuffer stringBuffer(String value) {
        byte[] bytes = value.getBytes(StandardCharsets.UTF_8);

        NettyDataBufferFactory nettyDataBufferFactory = new NettyDataBufferFactory(ByteBufAllocator.DEFAULT);
        DataBuffer buffer = nettyDataBufferFactory.allocateBuffer(bytes.length);
        buffer.write(bytes);
        return buffer;
    }

    //执行顺序
    @Override
    public int getOrder() {
        return 1;
    }
}
