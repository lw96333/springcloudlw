package com.lw.springcloud.program.controller;

import com.lw.springcloud.program.entity.Relust;
import com.lw.springcloud.program.entity.User;
import com.lw.springcloud.program.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lw
 * @create 2021-02-26-14:59
 */
@RestController
@RequestMapping("/user")
public class UserFeignController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Relust<User> getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
}
