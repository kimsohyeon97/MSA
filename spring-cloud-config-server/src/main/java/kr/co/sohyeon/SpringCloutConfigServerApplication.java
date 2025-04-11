package kr.co.sohyeon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringCloutConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloutConfigServerApplication.class, args);
    }

}
