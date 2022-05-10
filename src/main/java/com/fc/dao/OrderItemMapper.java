package com.fc.dao;

import com.fc.entity.OrderItem;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemMapper {
    int insert(OrderItem item);
}