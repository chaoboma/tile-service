package com.application.common;


import cn.hutool.core.util.StrUtil;
import lombok.Data;

/**
 * 分页查询
 *
 * @author sakuno
 */
@Data
public class PageParams {
    /**
     * 要查询的页码
     */
    private Integer pageNum = 0;

    /**
     * 页大小
     */
    private Integer pageSize = 10;

    /**
     * 排序字段
     */
    private String sort;

    /**
     * 排序方式
     */
    private String sortType;


    public boolean needToSort() {
        return StrUtil.isNotBlank(sort) && StrUtil.isNotBlank(sortType);
    }

    public boolean isAsc() {
        return "ascending".equalsIgnoreCase(sort) || sort.contains("asc");
    }

}