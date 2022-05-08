package com.fc.dao;

import com.fc.entity.Book;

import java.util.List;
import java.util.Set;

import com.fc.entity.Booktype;
import com.fc.entity.Recommend;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMapper {
    List<Book> findAllByRecommendType(@Param("type") int type);

    List<Book> search(String keyword);

    Book findById(Integer bid);

    List<Book> findAll();

    List<Book> findAllByType(Integer btid);

    List<Recommend> books(Integer rtype);
}