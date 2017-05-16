package com.chen.web;

import com.chen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by tian on 2017/5/15 上午10:54
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="toLogin.do",method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value="login.do",method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, HttpSession session) {
        ModelAndView mav= new ModelAndView();
        //获取用户输入的用户名
        String username = request.getParameter("username");
        //获取用户输入的密码
        String pwd = request.getParameter("password");
        Integer userId = null;
        //调用login方法
        String result = userService.login(username,pwd,session);
        //result为空表示登录成功
        if(result==null){
            mav.addObject("username",username);
            mav.setViewName("index");
        }
        //登录失败，前往login页面，并显示错误信息
        else{
            mav.addObject("error",result);
            mav.setViewName("login");
        }
        return mav;
    }
}
