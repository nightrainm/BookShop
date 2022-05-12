package com.fc.dao;

import com.fc.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    List<Order> findOrder(@Param("ostatus") Integer ostatus, @Param("uid") Integer uid);

    List<Order> findAllByUserId(int i);

    int insert(Order order);


    List<Order> findAll();

    List<Order> findAllByStatus(Integer ostatus);

    int delete(String oid);

    int update(String oid, Integer ostatus);
}