package com.fc.service;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

public interface BookService {



    ModelAndView findById(Integer bid, ModelAndView mv, HttpSession session);

    ModelAndView findAllByType(ModelAndView mv, Integer pageNumber, Integer pageSize, Integer btid);

    ModelAndView books(Integer rtype, Integer pageNumber, Integer pageSize, ModelAndView mv);

    ModelAndView search(ModelAndView mv, Integer pageNumber, Integer pageSize, String keyword);
}
