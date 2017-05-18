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

    /**
     * 用户登录
     * @param username
     * @param password
     * @param session
     * @return
     */
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

    /**
     * 注册：用户基本信息
     * @param username
     * @param email
     * @param password
     * @param password2
     * @return
     */
    public String baseRegister(String username,String email,String password,String password2,HttpSession session){
        if(username==null||username.trim().equals("")){
            return "用户名不能为空";
        }
        if(username.length()<3||username.length()>10){
            return "用户名必须为3-10位";
        }
        if(email==null||email.trim().equals("")){
            return "邮箱不能为空";
        }
        if(!email.matches("^\\w{5,15}@\\w{1,10}.\\w{1,5}$")){
            return "邮箱格式错误";
        }
        if(password==null||password.trim().equals("")){
            return "密码不能为空";
        }
        if(!password.matches("^[\\w_]{6,20}$")){
            return "密码格式错误";
        }
        if(!password.equals(password2)){
            return "两次密码不一致";
        }
        //检查用户名是否存在
        if(userDAO.findUserByUsername(username)!=null){
            return "用户名已存在";
        }
        //检查邮箱是否存在
        if(userDAO.findUserByEmail(email)!=null){
            return "邮箱已注册";
        }

        userDAO.baseRegister(username, email, password);
        User user = userDAO.findUserByUsername(username);
        if(user==null){
            return "注册失败，请稍后再试";
        }
        session.setAttribute("user",user);
        return null;
    }

}
