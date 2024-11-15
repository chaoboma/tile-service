package com.application.domain.dto;


import com.application.utils.CheckGroup;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 接受请求中分页相关参数
 *
 * @author lyw
 */
public class PageDTO implements Serializable {

    private static final long serialVersionUID = -463875536102923558L;

    /**
     * 第多少页
     */
//    @Schema(description = "第多少页")
    @NotNull(message = "页码不能为空", groups = {CheckGroup.Query.class})
    private Integer pageNum;

    /**
     * 每页几条
     */
//    @Schema(description = "每页几条")
    @NotNull(message = "条数不能为空", groups = {CheckGroup.Query.class})
    private Integer pageSize;

    public PageDTO(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public PageDTO() {
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
