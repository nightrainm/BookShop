package com.fc.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface AdminManageBookService {
    String findById(Integer bid, HttpSession session);

    String insert(HttpServletRequest request);

    String getList(Integer pageNumber, Integer rtype, HttpServletRequest request);

    String change(Integer bid, Integer rtype, String method, Integer page);

    String update(HttpServletRequest request);
}
