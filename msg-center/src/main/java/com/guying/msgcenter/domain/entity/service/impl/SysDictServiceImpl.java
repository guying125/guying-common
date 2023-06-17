package com.guying.msgcenter.domain.entity.service.impl;

import com.guying.msgcenter.domain.entity.entity.SysDict;
import com.guying.msgcenter.domain.entity.mapper.SysDictRepository;
import com.guying.msgcenter.domain.entity.service.SysDictService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 字典表(SysDict)表服务实现类
 *
 * @author Guying
 * @since 2023-06-04 23:56:16
 */
@Service("sysDictService")
public class SysDictServiceImpl implements SysDictService {
    @Resource
    private SysDictRepository sysDictRepository;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysDict queryById(Long id) {
        return this.sysDictRepository.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param sysDict     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<SysDict> queryByPage(SysDict sysDict, PageRequest pageRequest) {
        long total = this.sysDictRepository.count(sysDict);
        return new PageImpl<>(this.sysDictRepository.queryAllByLimit(sysDict, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param sysDict 实例对象
     * @return 实例对象
     */
    @Override
    public SysDict insert(SysDict sysDict) {
        this.sysDictRepository.insert(sysDict);
        return sysDict;
    }

    /**
     * 修改数据
     *
     * @param sysDict 实例对象
     * @return 实例对象
     */
    @Override
    public SysDict update(SysDict sysDict) {
        this.sysDictRepository.update(sysDict);
        return this.queryById(sysDict.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysDictRepository.deleteById(id) > 0;
    }
}
