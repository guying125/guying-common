package com.guying.fourlayer.easycodetest.test1.domain.easycodegenerate.domainservice.impl;

import com.guying.fourlayer.easycodetest.test1.domain.easycodegenerate.entity.SysConfig;
import com.guying.fourlayer.easycodetest.test1.domain.easycodegenerate.domainservice.SysConfigDomainService;
import com.guying.fourlayer.easycodetest.test1.domain.easycodegenerate.support.repository.SysConfigRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

/**
 * 配置表(SysConfig) 领域服务实现类
 *
 * @author Guying
 * @since 2023-06-24 23:27:24
 */
@RequiredArgsConstructor
@Slf4j
@Service("sysConfigDomainService")
public class SysConfigDomainServiceImpl implements SysConfigDomainService {

    private final SysConfigRepository sysConfigRepository;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysConfig queryById(Long id) {
        return null;
    }

    /**
     * 分页查询
     *
     * @param sysConfig   筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<SysConfig> queryByPage(SysConfig sysConfig, PageRequest pageRequest) {
        return null;
    }

    /**
     * 新增数据
     *
     * @param sysConfig 实例对象
     * @return 实例对象
     */
    @Override
    public SysConfig insert(SysConfig sysConfig) {
        return null;
    }

    /**
     * 修改数据
     *
     * @param sysConfig 实例对象
     * @return 实例对象
     */
    @Override
    public SysConfig update(SysConfig sysConfig) {
        return null;
    }
}
