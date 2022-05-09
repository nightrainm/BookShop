package com.fc.service;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

public interface OrderService {
    ModelAndView findAll(ModelAndView mv, HttpSession session);

    ModelAndView insert(HttpSession session, ModelAndView mv, String opaytype);

    ModelAndView submit(ModelAndView mv, HttpSession session);

    String buyBook(Integer bid, HttpSession session);
}
