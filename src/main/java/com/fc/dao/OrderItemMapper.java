package com.fc.dao;

import com.fc.entity.OrderItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemMapper {
    int insert(OrderItem item);

    int deleteByOid(String oid);

    List<OrderItem> findAllByOid(String oid);
}