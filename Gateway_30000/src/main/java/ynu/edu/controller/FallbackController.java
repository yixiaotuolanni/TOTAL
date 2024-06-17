package ynu.edu.controller;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/fallback")
public class FallbackController {
    @RequestMapping("/business")
    public Mono<Void> business(ServerHttpRequest request, ServerHttpResponse response) {
        response.setStatusCode(HttpStatusCode.valueOf(504));
        String responseBody = "business服务正忙，请稍后再试";
        DataBuffer dataBuffer = response.bufferFactory().wrap(responseBody.getBytes(StandardCharsets.UTF_8));

        return response.writeWith(Mono.just(dataBuffer));
    }
    @RequestMapping("/cart")
    public Mono<ServerHttpResponse> cart(ServerHttpRequest request, ServerHttpResponse response) {
        response.setStatusCode(HttpStatusCode.valueOf(406));
        return Mono.just(response);
    }
    @RequestMapping("/delivery-address")
    public Mono<String> deliveryAddress(ServerHttpRequest request, ServerHttpResponse response) {
        return Mono.just("地址服务正忙，请稍后再试");
    }
    @RequestMapping("/food")
    public Mono<String> food(ServerHttpRequest request, ServerHttpResponse response) {
        return Mono.just("食品服务正忙，请稍后再试");
    }
    @RequestMapping("/orders")
    public Mono<String> orders(ServerHttpRequest request, ServerHttpResponse response) {
        return Mono.just("订单服务正忙，请稍后再试");
    }
    @RequestMapping("/user")
    public Mono<String> user(ServerHttpRequest request, ServerHttpResponse response) {
        return Mono.just("用户服务正忙，请稍后再试");
    }
}
