package com.application.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
@Mapper

public interface CommonMapper extends BaseMapper<String> {
    /**
     * TODO 查询数据
     * @param
     * @return
     */

    Object querySql(@Param("sql") String sql) ;

}