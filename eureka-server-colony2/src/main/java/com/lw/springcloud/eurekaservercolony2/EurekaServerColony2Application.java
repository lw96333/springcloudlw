package com.lw.springcloud.eurekaservercolony2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaServer
@ComponentScan("com.lw")
public class EurekaServerColony2Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerColony2Application.class, args);
    }

}
