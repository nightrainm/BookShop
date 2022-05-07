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

    @Override
    public String insert(HttpServletRequest request) {
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        //拿到普通字段
        Book book = new Book();
        book.setBisbn(req.getParameter("bisbn"));
        book.setBname(req.getParameter("bname"));
        book.setBauthor(req.getParameter("bauthor"));
        book.setBpublisher(req.getParameter("bpublisher"));
        book.setBprice(Double.valueOf(req.getParameter("bprice")));
        book.setBtid(Integer.valueOf(req.getParameter("btid")));
        book.setBstock(Integer.valueOf(req.getParameter("bstock")));
        book.setBmark(req.getParameter("bmark"));
        //上传图片
        String path = req.getServletContext().getRealPath("/images");
        MultipartFile cover = req.getFileMap().get("bcover");
        MultipartFile image1 = req.getFileMap().get("bimage1");
        MultipartFile image2 = req.getFileMap().get("bimage2");
        if (cover != null && cover.getOriginalFilename() != null && cover.getOriginalFilename().length() > 0) {
            book.setBcover(FileUploadUtil.fileUpload(cover, path));
        }
        if (image1 != null && image1.getOriginalFilename() != null && image1.getOriginalFilename().length() > 0) {
            book.setBimage1(FileUploadUtil.fileUpload(image1, path));

        }
        if (image2 != null && image2.getOriginalFilename() != null && image2.getOriginalFilename().length() > 0) {
            book.setBimage2(FileUploadUtil.fileUpload(image2, path));
        }

        mapper.insert(book);
        return "redirect:book_list?pageNumber=1&rtype=0";
    }
}
