package ynu.edu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import jakarta.annotation.Resource;
import ynu.edu.util.JwtTokenUtil;

@RestController
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Resource
    JwtTokenUtil jwtTokenUtil;

    @RequestMapping("/gettoken")
    public Mono<String> getToken(@RequestParam("userId") String userId) {
        logger.info("Received request to generate token for userId: {}", userId);
        String token = jwtTokenUtil.generateToken(userId);
        logger.info("Generated token: {}", token);
        return Mono.just(token);
    }

    @RequestMapping("validatetoken")
    public Mono<Boolean> validateToken(@RequestParam("token") String token) {
        logger.info("Received request to validate token: {}", token);
        boolean isValid = jwtTokenUtil.validateToken(token);
        logger.info("Token valid: {}", isValid);
        return Mono.just(isValid);
    }

    @RequestMapping("refreshtoken")
    public Mono<String> refreshToken(@RequestParam("token") String token) {
        logger.info("Received request to refresh token: {}", token);
        if (!jwtTokenUtil.validateToken(token)) {
            logger.warn("Token has expired: {}", token);
            return Mono.just("您的令牌已经过期，请重新登陆");
        }
        String newToken = jwtTokenUtil.refreshToken(token);
        logger.info("Generated new token: {}", newToken);
        return Mono.just(newToken);
    }
}

