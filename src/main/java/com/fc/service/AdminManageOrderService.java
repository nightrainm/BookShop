package com.fc.service;

import com.fc.entity.Order;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public interface AdminManageOrderService {

    ModelAndView list(ModelAndView mv, Integer pageNumber, Integer pageSize, Integer ostatus, HttpServletRequest request);

    ModelAndView delete(ModelAndView mv, String oid, Integer ostatus);

    ModelAndView change(ModelAndView mv, Order order);
}
