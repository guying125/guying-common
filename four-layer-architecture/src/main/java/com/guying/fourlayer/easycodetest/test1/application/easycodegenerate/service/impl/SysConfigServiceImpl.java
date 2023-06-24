package com.guying.fourlayer.easycodetest.test1.application.easycodegenerate.service.impl;

import com.guying.fourlayer.easycodetest.test1.application.easycodegenerate.assembler.SysConfigAssembler;
import com.guying.fourlayer.easycodetest.test1.application.easycodegenerate.wrapper.dto.SysConfigDTO;
import com.guying.fourlayer.easycodetest.test1.application.easycodegenerate.wrapper.dto.SysConfigReqDTO;
import com.guying.fourlayer.easycodetest.test1.domain.easycodegenerate.entity.SysConfig;
import com.guying.fourlayer.easycodetest.test1.domain.easycodegenerate.domainservice.SysConfigDomainService;
import com.guying.fourlayer.easycodetest.test1.application.easycodegenerate.service.SysConfigService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

/**
 * 配置表(SysConfig)表服务实现类
 *
 * @author Guying
 * @since 2023-06-24 23:27:23
 */
@RequiredArgsConstructor
@Slf4j
@Service("sysConfigService")
public class SysConfigServiceImpl implements SysConfigService {

    private final SysConfigDomainService sysConfigDomainService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 持久化对象
     */
    @Override
    public SysConfigDTO queryById(Long id) {
        return this.sysConfigDomainService.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param sysConfigReqDTO 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    @Override
    public Page<SysConfigDTO> queryByPage(SysConfigReqDTO sysConfigReqDTO, PageRequest pageRequest) {
        SysConfig sysConfig = SysConfigAssembler.INSTANCE.toSysConfig(sysConfigReqDTO);
        long total = this.sysConfigDomainService.count(sysConfig);

        return new PageImpl<>(this.sysConfigDomainService.queryAllByLimit(sysConfig, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param sysConfigReqDTO 持久化对象
     * @return 持久化对象
     */
    @Override
    public int insert(SysConfigReqDTO sysConfigReqDTO) {
        SysConfig sysConfig = SysConfigAssembler.INSTANCE.toSysConfig(sysConfigReqDTO);
        this.sysConfigDomainService.insert(sysConfig);

        return this.sysConfigDomainService.insert(sysConfig);
    }

    /**
     * 修改数据
     *
     * @param sysConfigReqDTO 持久化对象
     * @return 持久化对象
     */
    @Override
    public int update(SysConfigReqDTO sysConfigReqDTO) {
        SysConfig sysConfig = SysConfigAssembler.INSTANCE.toSysConfig(sysConfigReqDTO);
        this.sysConfigDomainService.update(sysConfig);
        return this.queryById(sysConfig.getId());
    }
}
