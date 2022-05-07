package com.fc.interceptor;


import com.fc.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

public class InitInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        User user = new User( 5, "admin", "999999", "管理员", new Date(), 0, "超级管理员", "18245631746", "东大软件园B园G1公寓");
        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);
        return true;
    }
}
