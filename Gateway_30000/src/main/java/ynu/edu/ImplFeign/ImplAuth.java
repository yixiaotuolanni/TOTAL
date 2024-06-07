package ynu.edu.ImplFeign;

import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ImplAuth {

    private final WebClient webClient;

    public ImplAuth(ReactorLoadBalancerExchangeFilterFunction lbFunction) {
        this.webClient = WebClient.builder()
                .filter(lbFunction)
                .baseUrl("http://auth")  // 使用服务发现机制
                .build();
    }

    public Mono<String> getToken(String userId) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("userId", userId);

        return webClient.post()
                .uri("/gettoken")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData(formData))
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<Boolean> validateToken(String token) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("token", token);

        return webClient.post()
                .uri("/validatetoken")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData(formData))
                .retrieve()
                .bodyToMono(Boolean.class);
    }
}


