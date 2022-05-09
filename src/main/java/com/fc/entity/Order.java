package com.fc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    {
        this.setItemList(new ArrayList<>());
        this.setItemMap(new HashMap<>());
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        this.setOid(format.format(System.currentTimeMillis()));
    }

    private String oid;

    private float ototal;

    private int oamount;

    private Integer ostatus;

    private Integer opaytype;

    private Integer uid;

    private Date odatetime;

    private String orealname;

    private String ophone;

    private String oaddress;

    private Map<Integer, OrderItem> itemMap;

    private List<OrderItem> itemList;
}