package com.fc.service;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

public interface OrderService {
    ModelAndView findAll(ModelAndView mv, HttpSession session);
}
