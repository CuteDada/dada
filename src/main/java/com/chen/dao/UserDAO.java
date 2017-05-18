package com.chen.dao;

import com.chen.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDAO {
    //根据用户名查找用户
    User findUserByUsername(@Param("username") String username);
    //根据id查找用户
    User findUserById(@Param("id") Integer id);
    //根据邮箱查找用户
    User findUserByEmail(@Param("email")String email);
    //基本信息注册
    void baseRegister(@Param("username")String username,@Param("email")String email,@Param("password")String password);
}
