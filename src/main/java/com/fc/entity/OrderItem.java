package com.fc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem implements Serializable {
    private Integer oiid;
    private float oiprice;
    private int oiamount;
    private Integer bid;
    private String oid;
    private Book book;
    private Order order;
}