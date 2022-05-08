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
    public ModelAndView login(ModelAndView mv, HttpServletRequest request , HttpServletResponse response, User tempUser) {
        mv = userService.login(mv, request, response ,tempUser);
        return mv;
    }



}
