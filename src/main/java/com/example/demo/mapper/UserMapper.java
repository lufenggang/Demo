package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    Integer save(User user);

    User findUserByPhone(@Param("phone") String phone);

    User findPwdByPhone(@Param("phone") String phone);
}
