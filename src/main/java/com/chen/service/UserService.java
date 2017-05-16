package com.chen.service;

import com.chen.dao.UserDAO;
import com.chen.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by com.chen on 2017/5/15 上午11:06
 */
@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public String login(String username, String password, HttpSession session){
        if(username==null||username.trim().equals("")){
            return "用户名不能为空";
        }
        if(password==null||password.trim().equals("")){
            return "密码不能为空";
        }
        User user = userDAO.findUserByUsername(username);
        if(user==null){
            return "该用户不存在";
        }
        if(password.equals(user.getPassword())){
            session.setAttribute("user",user);
            return null;
        }else{
            return "用户名或密码错误";
        }
    }

}
