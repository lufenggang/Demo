package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.requestVo.LoginRequest;

public interface UserService {

    Integer save(User user);

    String login(LoginRequest loginRequest);
}
