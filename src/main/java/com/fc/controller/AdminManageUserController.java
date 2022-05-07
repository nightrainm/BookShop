package com.fc.controller;

import com.fc.entity.User;
import com.fc.service.AdminManageUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @GetMapping("user_edit_show")
    public ModelAndView userEditShow(Integer uid,HttpSession session,ModelAndView mv){
        mv = adminManageUserService.serEditShow(uid,session,mv);
        return mv;
    }
    @RequestMapping("user_list")
    public ModelAndView user_list(@RequestParam("pageNumber") Integer pageNumber, ModelAndView mv, HttpSession session){
        mv = adminManageUserService.user_list(mv,pageNumber,session);
        return mv;
    }
    @GetMapping("user_delete")
    public ModelAndView delete(Integer uid,ModelAndView mv){
        mv = adminManageUserService.delete(uid,mv);
        return mv;
    }

    @PostMapping("user_update")
    public ModelAndView userUpdate(User user,HttpSession session,ModelAndView mv){
        mv = adminManageUserService.update(user,session,mv);

        return mv;
    }


}
