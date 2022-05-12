package com.fc.controller;

import com.fc.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;
    @RequestMapping("/")
    public String init(HttpServletRequest request ,
                       @RequestParam(value = "pageNumber",defaultValue = "1")Integer pageNumber,
                       @RequestParam(value = "pageSize",defaultValue = "8") Integer pageSize){
        return  indexService.init(request,pageNumber,pageSize);
    }
}
