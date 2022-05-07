package com.fc.service;

import com.fc.entity.User;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

public interface AdminManageUserService {

    ModelAndView userAdd(ModelAndView mv, HttpSession session, User user);

    ModelAndView serEditShow(Integer uid, HttpSession session, ModelAndView mv);

    ModelAndView user_list(ModelAndView mv, Integer pageNumber, HttpSession session);

    ModelAndView delete(Integer uid, ModelAndView mv);

    ModelAndView update(User user, HttpSession session, ModelAndView mv);
}
