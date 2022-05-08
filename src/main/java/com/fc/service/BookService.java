package com.fc.service;

import com.fc.entity.Book;
import com.fc.entity.Booktype;
import com.fc.entity.Recommend;
import com.fc.vo.PageVO;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface BookService {


    ModelAndView search(Integer pageNum, Integer pageSize, String keyword, ModelAndView mv, HttpSession session);

    ModelAndView findById(Integer bid, ModelAndView mv, HttpSession session);

    ModelAndView findAllByType(ModelAndView mv, Integer pageNumber, Integer pageSize, Integer btid);
}
