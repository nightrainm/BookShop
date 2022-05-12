package com.fc.service;


import com.fc.entity.User;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface UserService {
    String login(HttpServletRequest request, HttpServletResponse response, User tempUser);

    ModelAndView logout(ModelAndView mv, HttpSession session, HttpServletResponse response);

    ModelAndView register(User user, ModelAndView mv);

    ModelAndView changePassword(Integer uid, String oldupwd, String upwd, ModelAndView mv, HttpSession session);

    ModelAndView change(ModelAndView mv, User user, HttpSession session);
}
