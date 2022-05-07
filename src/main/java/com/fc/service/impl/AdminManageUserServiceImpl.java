package com.fc.service.impl;

import com.fc.dao.UserMapper;
import com.fc.entity.User;
import com.fc.service.AdminManageUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Service
public class AdminManageUserServiceImpl implements AdminManageUserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public ModelAndView userAdd(ModelAndView mv, HttpSession session, User user) {
        user.setUmark("普通用户");
        user.setUrole(1);
        if (user.getUredgt() == null) {
            user.setUredgt(new Date());
        }

        int affectedRows = userMapper.insert(user);
        if (affectedRows > 0) {
            System.out.println("进入跳转");
            mv.setViewName("forward:user_list?pageNumber=1");
        } else {
            session.setAttribute("msg", "用户名重复");

            mv.setViewName("/admin/user_add");

        }

        return mv;
    }

    @Override
    public ModelAndView serEditShow(Integer uid, HttpSession session, ModelAndView mv) {
        User user = userMapper.selectByPrimaryKey(uid);
        if (user != null) {
            session.setAttribute("u", user);
            mv.setViewName("/admin/user_edit");
        } else {
            mv.setViewName("/user_list?pageNumber=1");
        }
        return mv;
    }

}



