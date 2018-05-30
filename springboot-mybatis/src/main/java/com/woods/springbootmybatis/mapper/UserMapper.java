package com.woods.springbootmybatis.mapper;

import com.woods.springbootmybatis.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "name", column = "name"),
    })
    List<User> queryUsers();

    @Select("SELECT * FROM user WHERE id = #{id}")
    User selectUserForId(@Param("id") int id);

}
