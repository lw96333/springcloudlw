package com.lw.springcloud.program.service.impl;

import com.lw.springcloud.program.entity.Relust;
import com.lw.springcloud.program.entity.User;
import com.lw.springcloud.program.service.UserService;
import org.springframework.stereotype.Component;

/**
 * @author lw
 * @create 2021-02-26-15:06
 */
@Component
public class UserFallbackService implements UserService {
    @Override
    public Relust<User> getUser(Long id) {
        return new Relust("调用失败，服务被降级",500);
    }
}
