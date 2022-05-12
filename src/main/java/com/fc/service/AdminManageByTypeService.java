package com.fc.service;

import com.fc.entity.Booktype;

import javax.servlet.http.HttpServletRequest;

public interface AdminManageByTypeService {
    String findAll(HttpServletRequest request);

    String insert(String name, HttpServletRequest request);

    String delete(Integer id, HttpServletRequest request);

    String update(Booktype booktype, HttpServletRequest request);
}
