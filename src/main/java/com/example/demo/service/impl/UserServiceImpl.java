package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.entity.requestVo.LoginRequest;
import com.example.demo.exception.LfgException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.example.demo.util.JWTUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public void checkGeShi(String phone){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(phone.trim());
        if(!isNum.matches()){
            throw new LfgException(20001,"请检查手机号码格式！");
        }
    }

    @Override
    public Integer save(User user) {
        if(StringUtils.isEmpty(user.getPhone())||StringUtils.isEmpty(user.getPwd())||StringUtils.isEmpty(user.getPhone())){
            throw new LfgException(20001,"用户信息不能为空，请检查必填项！");
        }
        if(userMapper.findUserByPhone(user.getPhone())!=null){
            throw new LfgException(20001,"用户手机号已经注册！");
        }
        if(user.getPhone().length()!=11){
            throw new LfgException(20001,"请检查手机号码格式！");
        }
        checkGeShi(user.getPhone());
        return  userMapper.save(user);
    }

    @Override
    public String login(LoginRequest loginRequest) {
        if(StringUtils.isEmpty(loginRequest.getPhone())||StringUtils.isEmpty(loginRequest.getPwd())){
            throw new LfgException(20001,"用户名和密码不能为空！");
        }
        User user = userMapper.findPwdByPhone(loginRequest.getPhone());
        if(user==null){
            throw new LfgException(20001,"无效用户");
        }
        if(!user.getPwd().equals(loginRequest.getPwd())){
            throw new LfgException(20001,"用户名或密码错误！");
        }
        String token = JWTUtils.geneJsonWebToken(user);
        return token;
    }
}
