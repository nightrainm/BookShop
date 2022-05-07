package com.fc.service;

import com.fc.entity.User;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

public interface AdminManageUserService {

    ModelAndView userAdd(ModelAndView mv, HttpSession session, User user);
}
