package com.fc.service.impl;

import com.fc.dao.BookMapper;
import com.fc.dao.BookTypeMapper;
import com.fc.entity.Book;
import com.fc.entity.Booktype;
import com.fc.entity.Recommend;
import com.fc.service.BookService;
import com.fc.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public ModelAndView search(Integer pageNum, Integer pageSize, String keyword, ModelAndView mv, HttpSession session) {
        List<Book> list=bookMapper.search("%"+keyword+"%");
        PageVO<Book> pageVO = new PageVO<>(list);
        session.setAttribute("p", pageVO);
        mv.setViewName("book_search");
        return mv;
    }
    @Override
    public ModelAndView findById(Integer bid, ModelAndView mv, HttpSession session) {
        Book book=bookMapper.findById(bid);
        session.setAttribute("book", book);
        mv.setViewName("book_detail");
        return mv;
    }

    @Override
    public ModelAndView findAllByType(ModelAndView mv, Integer pageNumber, Integer pageSize, Integer btid) {
        List<Book> list;
        PageHelper.startPage(pageNumber, pageSize);
        if (btid < 0){
            list = bookMapper.findAll();
        }else {
            list = bookMapper.findAllByType(btid);
        }
        PageVO<Book> pageVO = new PageVO<>(list);
        if(list.size() > 0){
            String btname = pageVO.getList().get(0).getBtname();
            mv.addObject("t", btname);
            mv.addObject("p", pageVO);
            mv.addObject("btid", btid);
            mv.setViewName("booktypes_list");
        }
        return mv;
    }


    //


   //


}
