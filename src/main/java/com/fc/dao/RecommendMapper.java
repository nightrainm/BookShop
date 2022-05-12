package com.fc.dao;

import com.fc.entity.Recommend;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendMapper {
    List<Recommend> findAllByBookId(@Param("id") Integer id);

    int insert(@Param("type") Integer type, @Param("id") Integer id);

    int deleteAllByBookId(@Param("id") Integer id);

    int delete(@Param("type") Integer type, @Param("id") Integer id);
}