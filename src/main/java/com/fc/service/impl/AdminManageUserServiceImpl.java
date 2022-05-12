package com.fc.service.impl;

import com.fc.dao.UserMapper;
import com.fc.entity.User;
import com.fc.service.AdminManageUserService;
import com.fc.vo.PageVO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class AdminManageUserServiceImpl implements AdminManageUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ModelAndView userAdd(ModelAndView mv, User user) {
        user.setUmark("普通用户");
        user.setUrole(1);
        if (user.getUredgt() == null) {
            user.setUredgt(new Date());
        }
        try {
            int affectedRows = userMapper.insert(user);
            if (affectedRows > 0) {
                mv.setViewName("redirect:user_list?pageNumber=1");
            } else {
                mv.addObject("msg", "服务器繁忙请稍后再试！");
                mv.setViewName("admin/user_add");
            }
        } catch (Exception e) {
            mv.addObject("msg", "用户名重复");
            mv.setViewName("admin/user_add");
        }
        return mv;
    }

    @Override
    public ModelAndView userEditShow(Integer uid, HttpSession session, ModelAndView mv) {
        try {
            User user = userMapper.findById(uid);
            if (user != null) {
                session.setAttribute("u", user);
                mv.setViewName("admin/user_edit");
            } else {
                mv.setViewName("redirect:/user_list?pageNumber=1");
            }
        } catch (Exception e) {
            e.printStackTrace();
            mv.setViewName("redirect:/user_list?pageNumber=1");
        }

        return mv;
    }

    @Override
    public ModelAndView user_list(ModelAndView mv, Integer pageNumber, HttpSession session) {
        try {
            PageHelper.startPage(pageNumber, 8);
            List<User> users = userMapper.findAll();
            PageVO<User> pageVO = new PageVO<>(users);
            session.setAttribute("p", pageVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.setViewName("admin/user_list");
        return mv;
    }

    @Override
    public ModelAndView delete(Integer uid, ModelAndView mv) {
        try {
            userMapper.delete(uid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.setViewName("redirect:user_list?pageNumber=1");
        return mv;
    }

    @Override
    public ModelAndView update(User user, HttpSession session, ModelAndView mv) {
        mv.setViewName("redirect:user_list?pageNumber=1");
        User tempUser = (User) session.getAttribute("user");
        if (tempUser == null || tempUser.getUid() == null || user.getUid() == null) {
            return mv;
        }
        try {
            userMapper.update(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user.getUid().equals(tempUser.getUid())) {
            tempUser.setUphone(user.getUphone());
            tempUser.setUaddress(user.getUaddress());
            session.setAttribute("user", tempUser);
        }
        return mv;
    }

    @Override
    public ModelAndView updatePassword(User user, ModelAndView mv, HttpSession session) {
        try {
            userMapper.update(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.setViewName("redirect:user_list?pageNumber=1");
        return mv;
    }


}



