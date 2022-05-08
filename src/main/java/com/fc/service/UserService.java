package com.fc.service;


import com.fc.entity.User;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface UserService {
    ModelAndView login(ModelAndView mv, HttpServletRequest request, HttpServletResponse response, User tempUser);

    ModelAndView logout(ModelAndView mv, HttpSession session, HttpServletResponse response);
}
