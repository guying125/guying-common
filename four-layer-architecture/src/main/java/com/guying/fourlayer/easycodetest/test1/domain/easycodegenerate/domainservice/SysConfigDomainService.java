package com.guying.fourlayer.easycodetest.test1.domain.easycodegenerate.domainservice;

import com.guying.fourlayer.easycodetest.test1.domain.easycodegenerate.entity.SysConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 配置表(SysConfig) 领域服务接口
 *
 * @author Guying
 * @since 2023-06-24 23:27:24
 */
public interface SysConfigDomainService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysConfig queryById(Long id);

    /**
     * 分页查询
     *
     * @param sysConfig   筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<SysConfig> queryByPage(SysConfig sysConfig, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param sysConfig 实例对象
     * @return 实例对象
     */
    SysConfig insert(SysConfig sysConfig);

    /**
     * 修改数据
     *
     * @param sysConfig 实例对象
     * @return 实例对象
     */
    SysConfig update(SysConfig sysConfig);
}
