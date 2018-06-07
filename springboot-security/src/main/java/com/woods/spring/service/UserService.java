package com.woods.spring.service;

import com.woods.spring.dao.UserMapper;
import com.woods.spring.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

//    @Cacheable(key = "#id", value = "user")
    public User findUserById(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

//    @CacheEvict(key = "'getUsers'", value = "user")
    public User insert(Integer id, String name){
        User user = new User();
        user.setId(id);
        user.setName(name);
        userMapper.insert(user);
        return user;
    }

//    @Cacheable(key = "'getUsers'", value = "user")
    public List<User> getUsers(){
        return userMapper.selectUsers();
    }
}
