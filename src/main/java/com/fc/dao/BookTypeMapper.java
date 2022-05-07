package com.fc.dao;

import com.fc.entity.Booktype;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookTypeMapper {
    //查看所有类型
    List<Booktype> findTypesInfo();
    //添加
    int add(@Param("typeName")String typeName);
    //删除
    int delete(@Param("id") Integer id);
    //修改
    int update(Booktype booktype);

}