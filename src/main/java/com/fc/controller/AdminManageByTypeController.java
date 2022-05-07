package com.fc.controller;

import com.fc.entity.Booktype;
import com.fc.service.AdminManageByTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("admin")
@Controller
public class AdminManageByTypeController {
    @Autowired
    private AdminManageByTypeService adminManageByTypeService;
    @RequestMapping("type_list")
    public String TypeList(HttpServletRequest request){
        return adminManageByTypeService.findAll(request);
    }
    @RequestMapping("type_add")
    public String insert(String btname ,HttpServletRequest request){
        return adminManageByTypeService.add(btname,request);
    }
    @RequestMapping("type_delete")
    public String delete(Integer btid,HttpServletRequest request){
        return  adminManageByTypeService.delete(btid,request);
    }
    @RequestMapping("type_update")
    public String update(Booktype booktype,HttpServletRequest request){
        return  adminManageByTypeService.update(booktype,request);
    }
}
