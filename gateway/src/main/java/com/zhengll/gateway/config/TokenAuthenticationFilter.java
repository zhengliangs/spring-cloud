package com.zhengll.gateway.config;

import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @description token拦截器
 * @author hero良
 * @className TokenAuthenticationFilter
 * @date 2019/11/29 16:36
 */
@Slf4j
@Component
public class TokenAuthenticationFilter extends AbstractGatewayFilterFactory {

    private static final String Bearer_ = "Bearer ";

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpRequest.Builder mutate = request.mutate();
            ServerHttpResponse response = exchange.getResponse();
            try {
                //1.获取header中的Authorization
                String header = request.getHeaders().getFirst("Authorization");
                if (header == null || !header.startsWith(Bearer_)) {
                    throw new RuntimeException("请求头中Authorization信息为空");
                }
                //2.截取Authorization Bearer
                String token = header.substring(7);
                //可把token存到redis中，此时直接在redis中判断是否有此key，有则校验通过，否则校验失败
                if(!StringUtils.isEmpty(token)){
                    log.info("验证通过 token = {}", token);
                    //3.有token，把token设置到header中，传递给后端服务
                    mutate.header("userDetails",token).build();
                }else{
                    //4.token无效
                    log.info("token无效");
                    DataBuffer bodyDataBuffer = responseErrorInfo(response , HttpStatus.UNAUTHORIZED.toString() ,"无效的请求");
                    return response.writeWith(Mono.just(bodyDataBuffer));
                }
            }catch (Exception e){
                //没有token
                log.info("没有token");
                DataBuffer bodyDataBuffer = responseErrorInfo(response , HttpStatus.UNAUTHORIZED.toString() ,e.getMessage());
                return response.writeWith(Mono.just(bodyDataBuffer));
            }
            ServerHttpRequest build = mutate.build();
            return chain.filter(exchange.mutate().request(build).build());
        };
    }

    /**
     * 自定义返回错误信息
     * @param response ServerHttpResponse
     * @param status 状态码
     * @param message 消息体
     */
    public DataBuffer responseErrorInfo(ServerHttpResponse response , String status ,String message){
        HttpHeaders httpHeaders = response.getHeaders();
        httpHeaders.add("Content-Type", "application/json; charset=UTF-8");
        httpHeaders.add("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");

        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        Map<String,String> map = new HashMap<>();
        map.put("status",status);
        map.put("message",message);
        return response.bufferFactory().wrap(map.toString().getBytes());
    }
}
