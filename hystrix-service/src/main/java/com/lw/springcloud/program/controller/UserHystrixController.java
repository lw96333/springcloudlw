package com.lw.springcloud.program.controller;

import com.lw.springcloud.program.entity.Relust;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Action;

/**
 * @author lw
 * @create 2021-02-25-16:15
 */
@RestController
@RequestMapping("/user")
public class UserHystrixController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.user-service}")
    private String serviceUrl;

    @GetMapping("/{id}")
    @HystrixCommand(fallbackMethod = "fallbackMethod1")
    public Relust getUserById(@PathVariable Long id){
        System.out.println(serviceUrl);
        return restTemplate.getForObject("http://localhost:8201/user/{1}", Relust.class, id);
    }

    public Relust fallbackMethod1(@PathVariable Long id) {
        return new Relust("服务调用失败", 500);
    }
}
