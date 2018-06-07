package com.woods.spring.controller;

import com.woods.spring.domain.User;
import com.woods.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public User getUser(Integer id){
        return userService.findUserById(id);
    }

    @RequestMapping("/insert")
    public User inset(Integer id, String name){
        return userService.insert(id, name);
    }

    @RequestMapping("/getUsers")
    public List<User> getUsers(){
        return userService.getUsers();
    }

}
