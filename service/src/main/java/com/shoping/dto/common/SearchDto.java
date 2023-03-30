package com.shoping.dto.common;

import lombok.Data;

@Data
public class SearchDto {
    private Long id;
    private String keyword; //Tìm kiếm chung
    private Boolean isDeleted = false;

    private int pageIndex;
    private int pageSize;

    public int getOrDefaultPageIndex() {
        return pageIndex <= 0 ? 0 : pageIndex - 1;
    }

    public int getOrDefaultPageSize() {
        return pageSize == 0 ? 10 : pageSize;
    }
}
