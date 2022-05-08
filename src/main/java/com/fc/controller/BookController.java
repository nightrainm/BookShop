package com.fc.controller;

import com.fc.entity.Recommend;
import com.fc.service.BookService;
import com.fc.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller

public class BookController {
    @Autowired
    private BookService bookService;
    @RequestMapping("search_books")
    public ModelAndView search(ModelAndView mv, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "8") Integer pageSize, String keyword, HttpSession session) {
        return bookService.search(pageNum, pageSize, keyword,mv,session);
    }

}

