package com.fc.service.impl;

import com.fc.dao.OrderMapper;
import com.fc.entity.Order;
import com.fc.entity.User;
import com.fc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public ModelAndView findAll( ModelAndView mv, HttpSession session) {
        //获取user
        User user = (User) session.getAttribute("user");
        //
        if (user==null){
            mv.setViewName("redirect:/index");
        }
        assert user != null;
        Integer uid = user.getUid();
        List<Order> orderList = orderMapper.findAll(8);
        session.setAttribute("orderList",orderList);
        mv.setViewName("/order_list");
        return mv;

    }
}
