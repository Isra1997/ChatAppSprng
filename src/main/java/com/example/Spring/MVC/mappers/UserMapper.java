package com.example.Spring.MVC.mappers;

import com.example.Spring.MVC.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("Select * from USERS where username=#{username}")
    User getUser(String  username);

    @Insert("Insert into USERS(username,password,salt, firstname,lastname) " +
            "Values(#{username},#{password},#{salt},#{firstname},#{lastname})")
    @Options(useGeneratedKeys = true, keyProperty = "Id")
    int createUser(User user);

    @Delete("Delete from USERS where userid=#{Id}")
    void deleteUser(Integer Id);
}
