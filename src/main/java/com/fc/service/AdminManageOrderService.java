package com.fc.service;

import com.fc.entity.Order;
import org.springframework.web.servlet.ModelAndView;

public interface AdminManageOrderService {

    ModelAndView list(ModelAndView mv, Integer pageNumber, Integer pageSize, Integer ostatus);

    ModelAndView delete(ModelAndView mv, String oid, String ostatus);

    ModelAndView change(ModelAndView mv, Order order);
}
