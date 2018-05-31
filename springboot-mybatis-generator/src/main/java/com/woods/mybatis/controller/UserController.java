package com.woods.mybatis.controller;

import com.woods.mybatis.dao.UserMapper;
import com.woods.mybatis.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getUser")
    public User getUser(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

}
