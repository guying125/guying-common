package com.guying.fourlayer.easycodetest.test1.adapter.controller.easycodegenerate;

import com.guying.fourlayer.easycodetest.test1.adapter.model.request.SysConfigRequest;
import com.guying.fourlayer.easycodetest.test1.adapter.model.response.SysConfigResponse;
import com.guying.fourlayer.easycodetest.test1.application.easycodegenerate.assembler.SysConfigAssembler;
import com.guying.fourlayer.easycodetest.test1.application.easycodegenerate.service.SysConfigService;
import com.guying.fourlayer.easycodetest.test1.application.easycodegenerate.wrapper.dto.SysConfigDTO;
import com.guying.fourlayer.infrastructure.commons.global.UniResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 配置表(SysConfig)表控制层
 *
 * @author Guying
 * @since 2023-06-24 23:27:22
 */
@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/sysConfig")
public class SysConfigController {

    private final SysConfigService sysConfigService;

    /**
     * 分页查询
     *
     * @param sysConfigRequest 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public UniResponse<Page<SysConfigResponse>> queryByPage(SysConfigRequest sysConfigRequest, PageRequest pageRequest) {
        return UniResponse.of(this.sysConfigService.queryByPage(sysConfigRequest, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public UniResponse<SysConfigResponse> queryById(@PathVariable("id") Long id) {
        return UniResponse.of(this.sysConfigService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param sysConfigRequest 请求参数
     * @return 新增结果
     */
    @PostMapping
    public UniResponse<SysConfigResponse> add(@RequestBody SysConfigRequest sysConfigRequest) {
        return UniResponse.of(this.sysConfigService.insert(sysConfigRequest));
    }

    /**
     * 编辑数据
     *
     * @param sysConfigRequest 请求参数
     * @return 编辑结果
     */
    @PutMapping
    public UniResponse<SysConfigResponse> edit(SysConfigRequest sysConfigRequest) {
        return UniResponse.of(this.sysConfigService.update(sysConfigRequest));
    }
}
