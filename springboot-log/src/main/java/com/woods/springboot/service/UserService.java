package com.woods.springboot.service;

import com.woods.springboot.dao.UserMapper;
import com.woods.springboot.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    public User findUserById(Integer id){
        String key = "user_" + id;
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            User user = operations.get(key);
            LOGGER.info("findUserById : 从缓存中获取了>>" + user.toString());
            return user;
        }
        User user = userMapper.selectByPrimaryKey(id);
        operations.set(key, user);
        LOGGER.info("findUserById : user插入缓存 >> " + user.toString());
        return userMapper.selectByPrimaryKey(id);
    }

    public User insert(Integer id, String name){
        User user = new User();
        user.setId(id);
        user.setName(name);
        userMapper.insert(user);
        return user;
    }

    @Cacheable(key = "users")
    public List<User> getUsers(){
        return userMapper.selectUsers();
    }

}
