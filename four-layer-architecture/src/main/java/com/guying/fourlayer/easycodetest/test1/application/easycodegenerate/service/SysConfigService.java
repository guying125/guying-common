package com.guying.fourlayer.easycodetest.test1.application.easycodegenerate.service;

import com.guying.fourlayer.easycodetest.test1.application.easycodegenerate.wrapper.dto.SysConfigDTO;
import com.guying.fourlayer.easycodetest.test1.application.easycodegenerate.wrapper.dto.SysConfigReqDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 配置表(SysConfig)表应用服务接口
 *
 * @author Guying
 * @since 2023-06-24 23:27:23
 */
public interface SysConfigService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysConfigDTO queryById(Long id);

    /**
     * 分页查询
     *
     * @param sysConfigReqDTO 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    Page<SysConfigDTO> queryByPage(SysConfigReqDTO sysConfigReqDTO, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param sysConfigReqDTO 实例对象
     * @return 新增数量
     */
    int insert(SysConfigReqDTO sysConfigReqDTO);

    /**
     * 修改数据
     *
     * @param sysConfigReqDTO 实例对象
     * @return 更新数量
     */
    int update(SysConfigReqDTO sysConfigReqDTO);
}
