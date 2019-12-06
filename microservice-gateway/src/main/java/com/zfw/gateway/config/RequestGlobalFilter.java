//package com.zfw.gateway.config;
//
//import io.netty.buffer.ByteBufAllocator;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.cloud.gateway.support.BodyInserterContext;
//import org.springframework.core.Ordered;
//import org.springframework.core.io.buffer.DataBuffer;
//import org.springframework.core.io.buffer.DataBufferUtils;
//import org.springframework.core.io.buffer.NettyDataBufferFactory;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
//import org.springframework.stereotype.Component;
//import org.springframework.web.reactive.function.BodyInserter;
//import org.springframework.web.reactive.function.BodyInserters;
//import org.springframework.web.reactive.function.server.ServerRequest;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import java.io.UnsupportedEncodingException;
//import java.net.URI;
//import java.nio.CharBuffer;
//import java.nio.charset.StandardCharsets;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.concurrent.atomic.AtomicReference;
//import java.util.stream.Collectors;
//
///**
// * 全局过滤器
// * 所有请求都会执行
// * 可拦截get、post等请求做逻辑处理
// * @author hero良
// * @className RequestGlobalFilter
// * @description
// *
// * @date 2019/11/29 16:28
// */
//@Slf4j
//@Component
//public class RequestGlobalFilter implements GlobalFilter, Ordered {
//
//
//    //执行逻辑
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        ServerHttpRequest request= exchange.getRequest();
//        log.info(" *******url******* : " + request.getURI().toString());//打印每次请求的url
//
//        String method = request.getMethodValue();
//        String contentType = request.getHeaders().getFirst("Content-Type");
//
//        if ("POST".equals(method) && !contentType.startsWith("multipart/form-data")) {
//            //从请求里获取Post请求体
////            String bodyStr = resolveBodyFromRequest(request);
////            System.out.println("bodyStr======"+bodyStr);
////            //TODO 得到Post请求的请求参数后，做你想做的事
////
////            //下面的将请求体再次封装写回到request里，传到下一级，否则，由于请求体已被消费，后续的服务将取不到值
////            URI uri = request.getURI();
////            ServerHttpRequest newRequest = request.mutate().uri(uri).build();
////            DataBuffer bodyDataBuffer = stringBuffer(bodyStr);
////            Flux<DataBuffer> bodyFlux = Flux.just(bodyDataBuffer);
////
////            newRequest = new ServerHttpRequestDecorator(newRequest) {
////                @Override
////                public Flux<DataBuffer> getBody() {
////                    return bodyFlux;
////                }
////            };
////            //封装request，传给下一级
////            return chain.filter(exchange.mutate().request(request).build());
//            return DataBufferUtils.join(exchange.getRequest().getBody())
//                    .flatMap(dataBuffer -> {
//                        byte[] bytes = new byte[dataBuffer.readableByteCount()];
//                        dataBuffer.read(bytes);
//                        String bodyString = new String(bytes, StandardCharsets.UTF_8);
//                        log.info(bodyString);
//                        exchange.getAttributes().put("POST_BODY",bodyString);
//                        DataBufferUtils.release(dataBuffer);
//                        Flux<DataBuffer> cachedFlux = Flux.defer(() -> {
//                            DataBuffer buffer = exchange.getResponse().bufferFactory()
//                                    .wrap(bytes);
//                            return Mono.just(buffer);
//                        });
//
//                        ServerHttpRequest mutatedRequest = new ServerHttpRequestDecorator(
//                                exchange.getRequest()) {
//                            @Override
//                            public Flux<DataBuffer> getBody() {
//                                return cachedFlux;
//                            }
//                        };
//                        return chain.filter(exchange.mutate().request(mutatedRequest)
//                                .build());
//                    });
//        } else if ("GET".equals(method)) {
//            Map requestQueryParams = request.getQueryParams();
//            //TODO 得到Get请求的请求参数后，做你想做的事
//
//            System.out.println(requestQueryParams.toString());
//            return chain.filter(exchange);
//        }
//        return chain.filter(exchange);
//    }
//
//    /**
//     * 从Flux<DataBuffer>中获取字符串的方法
//     * @return 请求体
//     */
//    private String resolveBodyFromRequest(ServerHttpRequest serverHttpRequest) {
//        //获取请求体
//        Flux<DataBuffer> body = serverHttpRequest.getBody();
//
//        AtomicReference<String> bodyRef = new AtomicReference<>();
//        body.subscribe(buffer -> {
//            CharBuffer charBuffer = StandardCharsets.UTF_8.decode(buffer.asByteBuffer());
//            DataBufferUtils.release(buffer);
//            bodyRef.set(charBuffer.toString());
//        });
//        //获取request body
//        return bodyRef.get();
//    }
//
//    /**
//     * 参数封装
//     * @param value
//     * @return
//     */
//    private DataBuffer stringBuffer(String value) {
//        byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
//
//        NettyDataBufferFactory nettyDataBufferFactory = new NettyDataBufferFactory(ByteBufAllocator.DEFAULT);
//        DataBuffer buffer = nettyDataBufferFactory.allocateBuffer(bytes.length);
//        buffer.write(bytes);
//        return buffer;
//    }
//
//    //执行顺序
//    @Override
//    public int getOrder() {
//        return 1;
//    }
//
//}
