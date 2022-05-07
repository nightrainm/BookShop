package com.fc.dao;

import com.fc.entity.Recommend;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendMapper {
    List<Recommend> findByBookId(@Param("id") Integer id);
}