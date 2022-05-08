package com.fc.controller;

import com.fc.entity.User;
import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    //登录
    @PostMapping("login")
    public ModelAndView login(ModelAndView mv, HttpServletRequest request, HttpServletResponse response, User tempUser) {
        mv = userService.login(mv, request, response, tempUser);
        return mv;
    }

    //退出
    @GetMapping("logout")
    public ModelAndView logout(ModelAndView mv, HttpSession session, HttpServletResponse response) {
        return userService.logout(mv, session, response);
    }

    //注册
    @PostMapping("register")
    public ModelAndView addUser(User user,  ModelAndView mv) {
        return userService.register(user, mv);
    }
    //修改密码
    @RequestMapping("change_password")
    public ModelAndView changePassword(Integer uid,String oldupwd,String upwd,ModelAndView mv,HttpSession session){
        return userService.changePassword(uid,oldupwd,upwd,mv,session);
    }
    //修改手机号和地址
    @PostMapping("change_phone_and_address")
    public ModelAndView change(ModelAndView mv, User user,HttpSession session) {
        mv = userService.change(mv, user,session);
        return mv;
    }


}
