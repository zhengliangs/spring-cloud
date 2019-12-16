package com.zfw.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.util.Strings;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author hero良
 * @className VerifyGatewayFilter
 * @description
 * @date 2019/12/12 16:36
 */
@Slf4j
@Component
public class VerifyGatewayFilter implements GlobalFilter, Ordered {

    public static final String CACHE_REQUEST_BODY_OBJECT_KEY = "cachedRequestBodyObject";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        Object cacheBody = exchange.getAttribute(CACHE_REQUEST_BODY_OBJECT_KEY);
        if(cacheBody == null){
            return chain.filter(exchange);
        }
        String raw = toRaw((Flux<DataBuffer>)cacheBody);
        log.info(raw);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 100;
    }

    private static String toRaw(Flux<DataBuffer> body) {
        AtomicReference<String> rawRef = new AtomicReference<>();
        body.subscribe(buffer -> {
            byte[] bytes = new byte[buffer.readableByteCount()];
            buffer.read(bytes);
            DataBufferUtils.release(buffer);
            rawRef.set(Strings.fromUTF8ByteArray(bytes));
        });
        return rawRef.get();
    }
}


