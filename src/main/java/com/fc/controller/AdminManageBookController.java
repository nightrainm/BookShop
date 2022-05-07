package com.fc.controller;

import com.fc.service.AdminManageBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping("/admin")
@Controller
public class AdminManageBookController {
    @Autowired
    private AdminManageBookService adminManageBookService;
    @GetMapping("/book_edit_show")
    public String findById(Integer bid , HttpSession session){
        return adminManageBookService.findById(bid,session);
    }
    @PostMapping("/book_add")
    public  String insert(HttpServletRequest request){
        return  adminManageBookService.insert(request);
    }
    @GetMapping("book_list")
    public  String list(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, Integer rtype , HttpServletRequest request){
        return  adminManageBookService.getList(pageNumber ,rtype, request);
    }
}
