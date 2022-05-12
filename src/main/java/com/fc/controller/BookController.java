package com.fc.controller;

import com.fc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller

public class BookController {
    @Autowired
    private BookService bookService;
    @RequestMapping("search_books")
    public ModelAndView search(ModelAndView mv, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "8") Integer pageSize, String keyword) {
        return bookService.search(mv,pageNumber, pageSize, keyword);
    }
    @RequestMapping("book_detail")
    public ModelAndView detail(ModelAndView mv, Integer bid, HttpSession session) {
        return bookService.findById(bid,mv,session);
    }
    @RequestMapping("booktypes_list")
    public ModelAndView list(ModelAndView mv, @RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "8") Integer pageSize, Integer btid) {
        return   bookService.findAllByType(mv,pageNumber,pageSize,btid);
    }
    @RequestMapping("recommend_books")
    public ModelAndView books(
                              ModelAndView mv,
                              @RequestParam Integer rtype,
                              @RequestParam(defaultValue = "1") Integer pageNumber,
                              @RequestParam(defaultValue = "8") Integer pageSize) {
        return bookService.books(rtype, pageNumber, pageSize,mv);

    }

}

