package com.fc.controller;

import com.fc.entity.User;
import com.fc.service.AdminManageUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RequestMapping("admin")
@Controller
public class AdminManageUserController {

    @Autowired
    private AdminManageUserService adminManageUserService;
    @PostMapping("user_add")
    public ModelAndView userAdd(ModelAndView mv, HttpSession session, User user){
        mv = adminManageUserService.userAdd(mv,session,user);
        return mv;
    }
}
