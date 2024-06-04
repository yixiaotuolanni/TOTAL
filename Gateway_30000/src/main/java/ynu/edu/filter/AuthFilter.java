package ynu.edu.filter;

import jakarta.annotation.Resource;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import ynu.edu.util.JwtTokenUtil;

import java.util.ArrayList;

@Component
public class AuthFilter implements GlobalFilter {
    @Resource
    private JwtTokenUtil jwtTokenUtil;
    private static ArrayList<String> pathCan = new ArrayList<>();
    static {
        pathCan.add("/UserController/logIn");
        pathCan.add("/UserController/saveUser");
        pathCan.add("/BusinessController/listBusiness");
        pathCan.add("/BusinessController/listBusinessByOrderTypeId");
    }
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        try {
            if (!pathCan.contains(exchange.getRequest().getPath().toString())){
                String token = exchange.getRequest().getHeaders().get("Authorization").get(0);
                if (token == null){
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }
                //            if(token==null || jwtTokenUtil.validateToken(token)) {
//                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//                return exchange.getResponse().setComplete();
//            }
            }
        }catch (Exception e){
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }
}