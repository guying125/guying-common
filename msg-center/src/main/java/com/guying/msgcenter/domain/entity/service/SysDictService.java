package com.guying.msgcenter.domain.entity.service;

import com.guying.msgcenter.domain.entity.entity.SysDict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 字典表(SysDict)表服务接口
 *
 * @author Guying
 * @since 2023-06-04 23:56:16
 */
public interface SysDictService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysDict queryById(Long id);

    /**
     * 分页查询
     *
     * @param sysDict     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<SysDict> queryByPage(SysDict sysDict, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param sysDict 实例对象
     * @return 实例对象
     */
    SysDict insert(SysDict sysDict);

    /**
     * 修改数据
     *
     * @param sysDict 实例对象
     * @return 实例对象
     */
    SysDict update(SysDict sysDict);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
