package com.fc.service.impl;

import com.fc.dao.BookMapper;
import com.fc.entity.Book;
import com.fc.service.AdminManageBookService;
import com.fc.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

@Service
public class adminManageBookServiceImpl implements AdminManageBookService {
    @Autowired
    private BookMapper mapper;

    @Override
    public String findById(Integer bid, HttpSession session) {
        Book book = mapper.findById(bid);
        System.out.println(book.getBname());
        session.setAttribute("g", book);
        return "admin/book_edit";
    }


}
