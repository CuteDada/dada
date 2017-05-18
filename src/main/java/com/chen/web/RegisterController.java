package com.chen.web;

import com.chen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by tian on 2017/5/17 下午2:34
 */
@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "toRegister.do",method = RequestMethod.GET)
    public String toRegister(){
        return "register";
    }

    @RequestMapping(value = "baseRegister.do",method = RequestMethod.POST)
    public ModelAndView baseRegister(String username, String email, String password, String password2, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        String result = userService.baseRegister(username, email, password, password2, session);
        if(result!=null){
            //将错误信息返回页面
            modelAndView.addObject("error",result);
            //将用户输入信息返回页面
            modelAndView.addObject("username",username);
            modelAndView.addObject("email",email);
            modelAndView.addObject("password",password);
            modelAndView.addObject("password2",password2);
            modelAndView.setViewName("register");
            return modelAndView;
        }
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
