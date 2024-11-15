package com.application.common;


import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * <p>
 * Version		1.0.0
 *
 * @author sakuno <p>
 */
@Data
@NoArgsConstructor
public class PageVo<T> {
    /**
     * 当前页
     */
    private Long current;
    /**
     * 页大小
     */
    private Long size;

    /**
     * 总页数
     */
    private Long pages;

    /**
     * 总数据条数
     */
    private Long total;


    /**
     * 分页记录
     */
    private List<T> records;


    public static PageVo<Object> empty() {
        PageVo<Object> vo = new PageVo<>();
        vo.records = new ArrayList<>();
        vo.size = 0L;
        vo.pages = 0L;
        vo.current = 0L;
        vo.total = 0L;
        return vo;
    }


    public PageVo(IPage<?> page, List<T> records) {
        this.records = records;
        this.current = page.getCurrent();
        this.size = page.getSize();
        this.total = page.getTotal();
        this.pages = page.getPages();
    }

}

