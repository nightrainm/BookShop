package com.fc.service.impl;

import com.fc.dao.BookMapper;
import com.fc.dao.BookTypeMapper;
import com.fc.entity.Book;
import com.fc.entity.Booktype;
import com.fc.service.IndexService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookTypeMapper bookTypeMapper;

    @Override
    public String init(HttpServletRequest req, Integer pageNumber, Integer pageSize) {
        HttpSession session = req.getSession(true);
        //初始化图书
        //条幅(今日热销)
        PageHelper.startPage(pageNumber, 1);
        List<Book> list = bookMapper.findAllByRecommendType(1);
        session.setAttribute("scrollBook", list.get(0));
        //热销
        PageHelper.startPage(pageNumber, pageSize);
        list = bookMapper.findAllByRecommendType(2);
        session.setAttribute("hotList", list);
        //新品
        PageHelper.startPage(pageNumber, pageSize);
        list = bookMapper.findAllByRecommendType(3);
        session.setAttribute("newList", list);
        //
        List<Booktype> bookTypes = bookTypeMapper.findTypesInfo();
        req.getServletContext().setAttribute("bookTypes", bookTypes);
        return "index";
    }
}
