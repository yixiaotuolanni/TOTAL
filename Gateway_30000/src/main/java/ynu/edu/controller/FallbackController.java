package ynu.edu.controller;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/fallback")
public class FallbackController {
    @RequestMapping("/business")
    public Mono<String> business(ServerHttpRequest request, ServerHttpResponse response) {
        return Mono.just("用户服务正忙，请稍后再试");
    }
    @RequestMapping("/cart")
    public Mono<String> cart(ServerHttpRequest request, ServerHttpResponse response) {
        return Mono.just("购物车服务正忙，请稍后再试");
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
