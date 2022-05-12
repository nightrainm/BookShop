package com.fc.filter;

import com.fc.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//角色权限过滤器
public class RolePermissionsFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.sendRedirect("/login.jsp");
            return;
        }
        User user = (User) session.getAttribute("user");
        if (!user.isAdmin()) {
            resp.sendRedirect("/error/notAccess.html");
            return;
        }
        chain.doFilter(request, response);
    }
}
