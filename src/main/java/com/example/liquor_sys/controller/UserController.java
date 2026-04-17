package com.example.liquor_sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.liquor_sys.entity.User;
import com.example.liquor_sys.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    // ----- 1. 登录接口 (保持不变) -----
    @PostMapping("/login")
    public Object login(@RequestBody User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", user.getUsername())
                .eq("password", user.getPassword());

        User loginUser = userMapper.selectOne(wrapper);

        if (loginUser != null) {
            return loginUser; // 登录成功
        } else {
            return "fail"; // 登录失败
        }
    }

    // 👇 ----- 2. 这是我们新加的“注册接口” ----- 👇
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        // 第一步：先去数据库查一查，这个用户名是不是已经被别人注册了
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", user.getUsername());
        User existUser = userMapper.selectOne(wrapper);

        if (existUser != null) {
            return "exist"; // 告诉前端：用户名已被占用
        }

        // 第二步：没被抢注，我们就给他分配默认身份：CUSTOMER（顾客），然后存入数据库
        user.setRole("CUSTOMER");
        userMapper.insert(user);
        return "success"; // 告诉前端：注册成功！
    }
}