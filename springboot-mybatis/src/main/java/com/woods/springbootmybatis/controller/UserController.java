package com.woods.springbootmybatis.controller;

import com.woods.springbootmybatis.domain.User;
import com.woods.springbootmybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getUsers")
    public List<User> getUsers(){
        return userMapper.queryUsers();
    }
}
