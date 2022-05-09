package com.fc.dao;

import com.fc.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    List<Order> findAll(int id);

    int insert(Order order);
}