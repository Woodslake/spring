package com.woods.spring.service;

import com.woods.spring.dao.RoleMapper;
import com.woods.spring.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public List<Role> getRoles(){
        return roleMapper.getRoles();
    }
}
