package com.fc.service.impl;

import com.fc.dao.BookMapper;
import com.fc.dao.BookTypeMapper;
import com.fc.entity.Booktype;
import com.fc.service.AdminManageByTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class AdminManageByTypeServiceImpl implements AdminManageByTypeService {
    @Autowired
    private BookTypeMapper booktypeMapper;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public String findAll(HttpServletRequest request) {
        List<Booktype> list = booktypeMapper.findTypesInfo();
        request.setAttribute("list", list);
        return "admin/type_list";
    }

    @Override
    public String insert(String name, HttpServletRequest request) {
        try {
            booktypeMapper.insert(name);
            List<Booktype> list = booktypeMapper.findTypesInfo();
            request.getServletContext().setAttribute("bookTypes", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:type_list";
    }

    @Override
    public String delete(Integer id, HttpServletRequest request) {
        try {
            bookMapper.deleteAllByBookType(id);
            booktypeMapper.delete(id);
            List<Booktype> list = booktypeMapper.findTypesInfo();
            request.getServletContext().setAttribute("bookTypes", list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:type_list";
    }

    @Override
    public String update(Booktype booktype, HttpServletRequest request) {
        try {
            booktypeMapper.update(booktype);
            List<Booktype> list = booktypeMapper.findTypesInfo();
            request.getServletContext().setAttribute("bookTypes", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:type_list";
    }
}
