package com.fc.controller;

import com.fc.entity.Book;
import com.fc.service.AdminManageBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
