package ynu.edu.filter;

import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import ynu.edu.ImplFeign.ImplAuth;

import java.time.Duration;
import java.util.*;

@Component
public class AuthRequestFilter implements GlobalFilter, Ordered {
    private static final Logger logger = LoggerFactory.getLogger(AuthRequestFilter.class);

    @Resource
    private ImplAuth implAuth;

    private static final ArrayList<String> pathCan = new ArrayList<>();

    static {
        pathCan.add("/user/logIn");
        pathCan.add("/user/saveUser");
        pathCan.add("/business/listBusiness");
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String requestPath = exchange.getRequest().getPath().toString();
        logger.info("Request path: {}", requestPath);

        // 检查路径是否在允许的路径集合中
        if (!pathCan.contains(requestPath)) {
            // 获取令牌
            String token  = exchange.getRequest().getHeaders().getFirst("token");
            if (token == null || token.isEmpty()) {
                // 如果令牌不存在或为空，设置响应状态为未授权
                logger.warn("Token is missing or empty for request path: {}", requestPath);
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }
            logger.info("Token found: {}", token);

            // 调用验证令牌的外部服务
            return implAuth.validateToken(token)
                    .flatMap(isValid -> {
                        if (Boolean.TRUE.equals(isValid)) {
                            // 如果令牌有效，继续处理链中的下一个过滤器
                            logger.info("Token is valid for request path: {}", requestPath);
                            return chain.filter(exchange);
                        } else {
                            // 如果令牌无效，设置响应状态为未授权
                            logger.warn("Token is invalid for request path: {}", requestPath);
                            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                            return exchange.getResponse().setComplete();
                        }
                    });
        }

        // 如果路径在允许的路径集合中，继续处理链中的下一个过滤器
        logger.info("Request path is in the allowed list, continuing with filter chain: {}", requestPath);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
