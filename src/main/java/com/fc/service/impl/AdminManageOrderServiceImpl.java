package com.fc.service.impl;

import com.fc.dao.OrderItemMapper;
import com.fc.dao.OrderMapper;
import com.fc.entity.Order;
import com.fc.service.AdminManageOrderService;
import com.fc.vo.PageVO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class AdminManageOrderServiceImpl implements AdminManageOrderService {
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private OrderMapper orderMapper;


    @Override
    public ModelAndView list(ModelAndView mv, Integer pageNumber, Integer pageSize, Integer ostatus) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Order> list;
        if (ostatus == 1) {
            list = orderMapper.findAll();
        } else {
            list = orderMapper.findAllByStatus(ostatus);
        }
        mv.addObject("ostatus", ostatus);
        PageVO<Order> p = new PageVO<>(list);
        mv.addObject("p", p);
        mv.setViewName("admin/order_list");
        return mv;

    }

    @Override
    public ModelAndView delete(ModelAndView mv, String oid, Integer ostatus) {
        try {
            orderItemMapper.deleteByOid(oid);
            orderMapper.delete(oid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.setViewName("redirect:order_list?pageNumber=1&ostatus=" + ostatus);
        return mv;
    }

    @Override
    public ModelAndView change(ModelAndView mv, Order order) {
        try {
            orderMapper.update(order.getOid(), order.getOstatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.setViewName("redirect:order_list?pageNumber=1&ostatus=" + order.getOstatus());
        return mv;
    }
}