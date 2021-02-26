package com.lw.springcloud.program.service;

import com.lw.springcloud.program.entity.Relust;
import com.lw.springcloud.program.entity.User;
import com.lw.springcloud.program.service.impl.UserFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lw
 * @create 2021-02-26-14:12
 */
@FeignClient(value = "user-service", fallback = UserFallbackService.class)
public interface UserService {

    @GetMapping("/user/{id}")
    Relust<User> getUser(@PathVariable Long id);
}
