package com.fc.dao;

import com.fc.entity.Book;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMapper {

    List<Book> findAllByRecommendType(@Param("type") Integer type);

    Book findById(@Param("id") Integer id);

    int insert(Book book);

    List<Book> findAll();

    int update(Book book);

    int delete(@Param("id") Integer id);

    int deleteAllByBookType(@Param("btid") Integer id);
    List<Book> findAllByRecommendType(@Param("type") int type);

    List<Book> search(String keyword);

    List<Book> findAllByType(Integer btid);

}
