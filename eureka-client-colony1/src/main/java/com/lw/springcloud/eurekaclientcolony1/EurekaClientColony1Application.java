package com.lw.springcloud.eurekaclientcolony1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientColony1Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientColony1Application.class, args);
    }

}
