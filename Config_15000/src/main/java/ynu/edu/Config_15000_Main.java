package ynu.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Config_15000_Main {
    public static void main(String[] args) {
        SpringApplication.run(Config_15000_Main.class,args);
    }
}