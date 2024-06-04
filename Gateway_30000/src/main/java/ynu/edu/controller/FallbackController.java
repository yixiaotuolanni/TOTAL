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
    @RequestMapping("/food")
    public Mono<String> food(ServerHttpRequest request, ServerHttpResponse response) {
        return Mono.just("食品服务正忙，请稍后再试");
    }
}
