package ynu.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eureka_10001_Main {
    public static void main(String[] args) {
        SpringApplication.run(Eureka_10001_Main.class,args);
    }
}