package com.lw.springcloud.eurekaservercolony1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaServer
@ComponentScan("com.lw")
public class EurekaServerColony1Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerColony1Application.class, args);
    }

}
