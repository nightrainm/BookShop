package com.fc.service;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

public interface OrderService {
    ModelAndView findAll(ModelAndView mv, HttpSession session);

    ModelAndView insert(HttpSession session, ModelAndView mv, Integer opaytype);

    ModelAndView submit(ModelAndView mv, HttpSession session);

    String buyBook(Integer bid, HttpSession session);

    String lessenBook(Integer bid, HttpSession session);

    String deleteBooks(Integer bid, HttpSession session);
}
