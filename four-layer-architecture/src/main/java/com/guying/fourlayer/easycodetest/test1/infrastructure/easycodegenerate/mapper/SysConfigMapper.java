package com.guying.fourlayer.easycodetest.test1.infrastructure.easycodegenerate.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guying.fourlayer.easycodetest.test1.domain.easycodegenerate.entity.SysConfig;
import com.guying.fourlayer.easycodetest.test1.infrastructure.easycodegenerate.mapper.po.SysConfigPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 配置表(SysConfig)表数据库访问层
 *
 * @author Guying
 * @since 2023-06-24 23:27:24
 */
@Mapper
public interface SysConfigMapper extends BaseMapper<SysConfigPO> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysConfigPO queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param sysConfig 查询条件
     * @param pageable  分页对象
     * @return 对象列表
     */
    List<SysConfigPO> queryAllByLimit(SysConfig sysConfig, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param sysConfig 查询条件
     * @return 总行数
     */
    long count(SysConfig sysConfig);

    /**
     * 新增数据
     *
     * @param sysConfig 实例对象
     * @return 影响行数
     */
    int insert(SysConfig sysConfig);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysConfig> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysConfig> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysConfig> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SysConfig> entities);

    /**
     * 修改数据
     *
     * @param sysConfig 实例对象
     * @return 影响行数
     */
    int update(SysConfig sysConfig);
}
