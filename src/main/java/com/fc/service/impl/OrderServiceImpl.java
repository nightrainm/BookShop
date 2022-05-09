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

    @Override
    public ModelAndView insert(HttpSession session, ModelAndView mv, String opaytype) {
        Order order = (Order) session.getAttribute("order");
        User user = (User) session.getAttribute("user");
        assert user != null;
        Integer uid = user.getUid();

        order.setUid(9);
        order.setOstatus(2);
        order.setOpaytype(1);

        user.setUrealname( order.getOrealname());
        user.setUphone(order.getOphone());
        user.setUaddress(order.getOaddress());

        int affect= orderMapper.insert(order);
        if (affect>0){
            session.removeAttribute("order");
        }
        mv.setViewName("order_result");

        return mv;

    }
}
