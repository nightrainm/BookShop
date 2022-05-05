package com.fc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
    private Integer bid;
    private String bisbn;
    private String bname;
    private String bauthor;
    private String bpublisher;
    private String bcover;
    private String bimage1;
    private String bimage2;
    private Double bprice;
    private Integer btid;
    private String btname;
    private Integer bstock;
    private String bmark;
    private boolean isScroll;
    private boolean isHot;
    private boolean isNew;


}