package com.fc.dao;

import com.fc.entity.Book;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMapper {

    List<Book> findAllByRecommendType(@Param("type") int type);

    Book findById(@Param("id") Integer id);

}