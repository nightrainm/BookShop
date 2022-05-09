package com.fc.controller;

import com.fc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("order_list")
    public ModelAndView find(ModelAndView mv, HttpSession session){
        return orderService.findAll(mv,session);

    }
    @RequestMapping("order_confirm")
    public ModelAndView confirm(HttpSession session, ModelAndView mv, @RequestParam String opaytype){

        return orderService.insert(session,mv,opaytype);



    }
}
