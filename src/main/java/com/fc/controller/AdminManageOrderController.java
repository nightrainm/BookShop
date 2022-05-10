package com.fc.controller;

import com.fc.service.AdminManageOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("admin")
public class AdminManageOrderController {
    @Autowired
    private AdminManageOrderService orderListService;
    @RequestMapping("order_list")
    public ModelAndView list(HttpServletRequest request, ModelAndView mv, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "8") Integer pageSize, Integer ostatus){
        return orderListService.list(mv,pageNumber,pageSize,ostatus,request);
    }
    @GetMapping("order_delete")
    public ModelAndView delete(ModelAndView mv, String oid, Integer ostatus){
        return orderListService.delete(mv,oid,ostatus);
    }
}
