package ynu.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Gateway_8085_Main {
    public static void main(String[] args) {
        SpringApplication.run(Gateway_8085_Main.class,args);
    }
}