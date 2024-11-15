package com.application.constants;

import cn.hutool.core.collection.ListUtil;

import java.util.List;

/**
 * 基础常量
 *
 * @author sakuno
 * @since 2023/5/17
 */
public interface Cons {

    /**
     * 合并字符串
     */
    String MERGE_STR = "{}{}";

    /**
     * record id
     */
    String RECORD_ID = "recordId";
    /**
     * record Type
     */
    String RECORD_TYPE = "recordType";

    /**
     * 固定的几个乡镇所属的区县编号
     */
    List<String> COUNTRY_CODE = ListUtil.of("420323000000", "420324000000", "420325000000", "420526000000", "422823000000", "429021000000");

}
