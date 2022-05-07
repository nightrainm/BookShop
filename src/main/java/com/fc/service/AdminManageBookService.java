package com.fc.service;


import javax.servlet.http.HttpSession;

public interface AdminManageBookService {
    String findById(Integer bid, HttpSession session);


}
