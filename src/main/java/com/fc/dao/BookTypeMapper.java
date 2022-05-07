package com.fc.dao;

import com.fc.entity.Booktype;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookTypeMapper {
    //查看所有类型
    List<Booktype> findTypesInfo();


}