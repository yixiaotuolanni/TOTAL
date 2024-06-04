package ynu.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Config_15001_Main {
    public static void main(String[] args) {
        SpringApplication.run(Config_15001_Main.class,args);
    }
}