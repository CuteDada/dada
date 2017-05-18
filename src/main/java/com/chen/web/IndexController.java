package com.chen.web;

import com.chen.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by tian on 2017/5/13.
 */

@Controller
public class IndexController {
    /**
     * 前往首页
     * @param session
     * @return
     */
    @RequestMapping(value="toIndex.do",method = RequestMethod.GET)
    public ModelAndView printWelcome(HttpSession session) {
        ModelAndView mav= new ModelAndView();
        //判断用户是否登录
        if(session.getAttribute("user")!=null){
            User user = (User)session.getAttribute("user");
            mav.addObject("user",user);
            mav.setViewName("index");
            return mav;
        }
        //没有登录则前往登录页面
        else {
            mav.addObject("error","请先登录");
            mav.setViewName("login");
            return mav;
        }

    }




}
