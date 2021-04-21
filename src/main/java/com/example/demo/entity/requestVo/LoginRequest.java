package com.example.demo.entity.requestVo;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginRequest implements Serializable {

    private static final long serialVersionUID = 2641815695798848428L;

    private String phone;

    private String pwd;
}
