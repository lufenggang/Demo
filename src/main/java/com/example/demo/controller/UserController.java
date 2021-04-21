package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.entity.requestVo.LoginRequest;
import com.example.demo.service.UserService;
import com.example.demo.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public JsonData register(@RequestBody User user){
        Integer result = userService.save(user);
        return result>0?JsonData.success().msg("注册成功"):JsonData.error().msg("注册失败");
    }

    @PostMapping("login")
    public JsonData login(@RequestBody LoginRequest loginRequest){
        String token = userService.login(loginRequest);
        return token==null?JsonData.error().msg("登入失败，账号密码有误"):JsonData.success().data("token",token);
    }
}
