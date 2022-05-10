package com.fc.dao;

import com.fc.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    List<Order> findAllByUserId(int i);

    int insert(Order order);


    List<Order> findAll();

    List<Order> findAllByStatus(Integer ostatus);

    int delete(String oid);
}