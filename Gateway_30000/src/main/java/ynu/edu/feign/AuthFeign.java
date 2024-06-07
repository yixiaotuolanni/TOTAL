package ynu.edu.feign;

import jakarta.annotation.Resource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;
import ynu.edu.util.JwtTokenUtil;

public interface AuthFeign {
    static String path = "/auth";
    @RequestMapping("/gettoken")
    Mono<String> getToken(@RequestParam("userId") String userId);
    @RequestMapping("validatetoken")
    Mono<Boolean> validateToken(@RequestParam("token") String token);

}
