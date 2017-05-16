package com.chen.web;

import com.chen.dao.UserDAO;
import com.chen.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by tian on 2017/5/15 下午5:27
 */
@Controller
public class PicController {
    @Autowired
    private UserDAO userDAO;

    /**
     * 处理请求用户头像的请求
     * @param userId
     * @param response
     * @param session
     */
    @RequestMapping(value = "getUserPic.do",method = RequestMethod.GET)
    public void getUserPic(String userId, HttpServletResponse response, HttpSession session){
        try {
            Integer id; //用户id
            byte[] pic; //头像
            //如果传入的userId不为空，则查询该用户的pic
            if(userId != null && !userId.trim().equals("")) {
                id = Integer.valueOf(userId);
                //TODO 可以添加缓存，存储用户的信息，减少请求数据库的次数
                User user = userDAO.findUserById(id);
                pic = user.getPic();
            }
            //如果传入的userId为空，则使用当前登录用户的pic
            else {
                User user = (User)session.getAttribute("user");
                if(user==null){
                    return;
                }
                pic = user.getPic();
            }
            //将pic输出到页面
            response.setContentType("image/jpg");
            ServletOutputStream sos = response.getOutputStream();
            sos.write(pic,0,pic.length);
        }catch (Exception e){
            return;
        }
    }
}
