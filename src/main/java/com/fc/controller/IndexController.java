package com.fc.controller;

import com.fc.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;
    @RequestMapping("/")
    public String init(HttpServletRequest request){
        return  indexService.init(request);
    }
}
