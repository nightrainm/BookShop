package com.fc.service.impl;

import com.fc.dao.BookMapper;
import com.fc.dao.OrderItemMapper;
import com.fc.dao.OrderMapper;
import com.fc.entity.Book;
import com.fc.entity.Order;
import com.fc.entity.OrderItem;
import com.fc.entity.User;
import com.fc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public ModelAndView findAll(ModelAndView mv, HttpSession session) {
        //获取user
        User user = (User) session.getAttribute("user");
        //
        if (user == null) {
            mv.setViewName("redirect:/");
        }
        assert user != null;
        Integer uid = user.getUid();
        List<Order> orderList = orderMapper.findAll(uid);
        session.setAttribute("orderList", orderList);
        mv.setViewName("order_list");
        return mv;
    }

    @Override
    public ModelAndView insert(HttpSession session, ModelAndView mv, Integer opaytype) {
        try {
            Order order = (Order) session.getAttribute("order");
            User user = (User) session.getAttribute("user");
            Integer uid = user.getUid();
            order.setUid(uid);
            order.setOstatus(2);
            order.setOpaytype(opaytype);
            order.setOrealname(user.getUrealname());
            order.setOphone(user.getUphone());
            order.setOaddress(user.getUaddress());
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            order.setOid(format.format(System.currentTimeMillis()));
            orderMapper.insert(order);
            session.removeAttribute("order");
            //
            Set<Map.Entry<Integer, OrderItem>> entrySet = order.getItemMap().entrySet();
            for (Map.Entry<Integer, OrderItem> entry : entrySet) {
                OrderItem item = entry.getValue();
                item.setOid(order.getOid());
                orderItemMapper.insert(item);
            }
            mv.addObject("msg", "购买成功！");
        } catch (Exception e) {
            e.printStackTrace();
            mv.addObject("failmsg", "购买失败！");
        }
        //mv.setViewName("redirect:/order_list");
        mv.setViewName("order_result");
        return mv;
    }

    @Override
    public ModelAndView submit(ModelAndView mv, HttpSession session) {
        User user = (User) session.getAttribute("user");

        if (user != null) {
            mv.setViewName("order_submit");
        } else {
            mv.setViewName("redirect:user_login.jsp");
        }
        return mv;
    }

    @Override
    public String buyBook(Integer bid, HttpSession session) {
        Order order = (Order) session.getAttribute("order");
        if (order == null) {
            order = new Order();
            session.setAttribute("order", order);
        }
        Book book = bookMapper.findById(bid);
        if (book == null) {
            return "fail";
        }
        Map<Integer, OrderItem> itemMap = order.getItemMap();
        if (!itemMap.containsKey(bid)) {
            itemMap.put(bid, new OrderItem());
        }
        OrderItem item = itemMap.get(bid);
        //
        item.setOiamount(item.getOiamount() + 1);
        item.setOiprice(book.getBprice());
        item.setBook(book);
        item.setBid(bid);
        //
        order.setOamount(order.getOamount() + 1);
        float tempMoney = order.getOtotal() + book.getBprice();
        String format = String.format("%.1f", tempMoney);
        float money = Float.parseFloat(format);
        order.setOtotal(money);
        return "ok";
    }
}
