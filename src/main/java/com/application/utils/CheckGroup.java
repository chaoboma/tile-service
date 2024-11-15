package com.application.utils;

import org.springframework.validation.annotation.Validated;

/**
 * {@link Validated} 的校验组
 *
 * @author lyw
 */
public interface CheckGroup {
    /**
     * 新增组
     */
    interface Add {
    }

    /**
     * 删除组
     */
    interface Delete {
    }

    /**
     * 修改组
     */
    interface Update {
    }

    /**
     * 查询标志
     */
    interface Query {
    }
}
