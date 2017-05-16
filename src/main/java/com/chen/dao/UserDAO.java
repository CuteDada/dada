package com.chen.dao;

import com.chen.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDAO {
    public User findUserByUsername(@Param("username") String username);

    public User findUserById(@Param("id") Integer id);
}
