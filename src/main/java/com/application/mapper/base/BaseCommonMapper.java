package com.application.mapper.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Collection;

/**
 * @program: bris-server
 * @description:
 * @author: yl
 * @create: 2023-04-26 15:14
 **/
public interface BaseCommonMapper<T> extends BaseMapper<T> {

    /**
     * 批量插入
     * @param entities 实例列表
     * @return 受影响行数
     */
    Integer insertBatchSomeColumn(Collection<T> entities);
}
