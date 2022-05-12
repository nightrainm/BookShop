package com.fc.vo;

import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVO<T> {
    private int pageNumber;
    private int pageSize;
    private long totalCount;
    private int totalPage;
    private List<T> list;

    //通过构造方法直接封装好
    public PageVO(List<T> list) {
        PageInfo<T> pageInfo = new PageInfo<>(list);
        this.pageNumber = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.totalCount = pageInfo.getTotal();
        this.totalPage = pageInfo.getPages();
        this.list = pageInfo.getList();
    }
}
