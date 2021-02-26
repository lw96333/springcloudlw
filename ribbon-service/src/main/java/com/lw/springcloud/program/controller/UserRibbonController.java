package com.lw.springcloud.program.controller;


import com.lw.springcloud.program.entity.Relust;
import com.lw.springcloud.program.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author lw
 * @create 2021-02-25-14:03
 */
@RestController
@RequestMapping("/user")
public class UserRibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.user-service}")
    private String userServiceUrl;

    @GetMapping("/{id}")
    public Relust getUser(@PathVariable Long id){
        System.out.println(userServiceUrl);
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", Relust.class, id);
    }

    @GetMapping("/getByUsername")
    public Relust getByUsername(@RequestParam String username) {
        return restTemplate.getForObject(userServiceUrl + "/user/getByUsername?username={1}", Relust.class, username);
    }

    @GetMapping("/getEntityByUsername")
    public Relust getEntityByUsername(@RequestParam String username) {
        ResponseEntity<Relust> entity = restTemplate.getForEntity(userServiceUrl + "/user/getByUsername?username={1}", Relust.class, username);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new Relust("操作失败", 500);
        }
    }

    @PostMapping("/insert")
    public Relust insert(@RequestBody User user) {
        return restTemplate.postForObject(userServiceUrl + "/user/insert", user, Relust.class);
    }

    @PostMapping("/update")
    public Relust update(@RequestBody User user) {
        return restTemplate.postForObject(userServiceUrl + "/user/update", user, Relust.class);
    }

    @PostMapping("/delete/{id}")
    public Relust delete(@PathVariable Long id) {
        return restTemplate.postForObject(userServiceUrl + "/user/delete/{1}", null, Relust.class, id);
    }
}
