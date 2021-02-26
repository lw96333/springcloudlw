package com.lw.springcloud.program.controller;
import	java.awt.font.NumericShaper.Range;

import com.lw.springcloud.program.entity.Relust;
import com.lw.springcloud.program.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lw
 * @create 2021-02-25-9:46
 */
@RestController
@RequestMapping("/user")
public class UserController {


    //@RequestBody 绑定Bean参数
    @PostMapping("/insert")
    public Relust insert(@RequestBody User user){
        return new Relust("操作成功", 200);
    }

    //@PathVariable是spring3.0的一个新功能：接收请求路径中占位符的值
    @GetMapping("/{id}")
    public Relust<User> getUser(@PathVariable Long id){
        User u = new User(id,"root","1234");
        System.out.println(u.getPassword());
        return new Relust<User>(u);
    }
    //@RequestParam将请求参数绑定到你控制器的方法参数上（是springmvc中接收普通参数的注解）
    @GetMapping("/listUsersByIds")
    public Relust<List<User>> listUsersByIds(@RequestParam List<Long> ids){
        List<User> list = new ArrayList<>();
        for(Long id : ids){
            User u = new User(id,"root"+id,"1234");
            list.add(u);
        }
        return new Relust<List<User>>(list);
    }

    @GetMapping("/getByUsername")
    public Relust<User> getByUserName(@RequestParam String userName){
        User u = new User(1L,userName,"1234");
        return new Relust<User>(u);
    }

    @PostMapping("/update")
    public Relust update(@RequestBody User user) {
        return new Relust("操作成功", 200);
    }

    @PostMapping("/delete/{id}")
    public Relust delete(@PathVariable Long id) {
        return new Relust("操作成功", 200);
    }
}
