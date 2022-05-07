package com.fc.service.impl;

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

    @Override
    public String findAll(HttpServletRequest request) {
        List<Booktype> list = booktypeMapper.findTypesInfo();
        request.setAttribute("list", list);
        return "admin/type_list";
    }

    @Override
    public String add(String name, HttpServletRequest request) {
        booktypeMapper.add(name);
        List<Booktype> list = booktypeMapper.findTypesInfo();
        request.getServletContext().setAttribute("bookTypes", list);
        return "redirect:type_list";
    }

    @Override
    public String delete(Integer id, HttpServletRequest request) {
        booktypeMapper.delete(id);
        List<Booktype> list = booktypeMapper.findTypesInfo();
        request.getServletContext().setAttribute("bookTypes", list);
        return "redirect:type_list";
    }

    @Override
    public String update(Booktype booktype, HttpServletRequest request) {
        booktypeMapper.update(booktype);
        List<Booktype> list = booktypeMapper.findTypesInfo();
        request.getServletContext().setAttribute("bookTypes", list);
        return "redirect:type_list";
    }
}
