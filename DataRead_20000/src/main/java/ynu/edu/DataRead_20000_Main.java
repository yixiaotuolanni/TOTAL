package ynu.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DataRead_20000_Main {
    public static void main(String[] args) {
        SpringApplication.run(DataRead_20000_Main.class,args);
    }
}
