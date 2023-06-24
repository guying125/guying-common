package com.guying.fourlayer.easycodetest.test1.infrastructure.easycodegenerate.mapper;

import com.guying.fourlayer.easycodetest.test1.domain.easycodegenerate.entity.SysConfig;
import com.guying.fourlayer.easycodetest.test1.infrastructure.easycodegenerate.mapper.dto.SysConfigRepoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 配置表(SysConfig)
 * 多表关联查询数据库访问层
 * 使用场景：通过多表关联查询数据
 *
 * @author Guying
 * @since 2023-06-24 23:27:24
 */
@Mapper
public interface SysConfigMultiMapper {
    /**
     * demo：通过多表关联查询数据
     */
    List<SysConfigRepoDTO> queryAllByLimit(SysConfig sysConfig);
}
