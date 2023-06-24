package com.guying.fourlayer.easycodetest.test1.application.easycodegenerate.assembler;

import com.guying.fourlayer.easycodetest.test1.adapter.model.request.SysConfigRequest;
import com.guying.fourlayer.easycodetest.test1.adapter.model.response.SysConfigResponse;
import com.guying.fourlayer.easycodetest.test1.application.easycodegenerate.wrapper.dto.SysConfigDTO;
import com.guying.fourlayer.easycodetest.test1.application.easycodegenerate.wrapper.dto.SysConfigReqDTO;
import com.guying.fourlayer.easycodetest.test1.domain.easycodegenerate.entity.SysConfig;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 配置表(SysConfig) 输入输出参数转换器
 *
 * @author Guying
 * @since 2023-06-24 23:27:23
 */
@Mapper(componentModel = "spring")
public interface SysConfigAssembler {
    SysConfigAssembler INSTANCE = Mappers.getMapper(SysConfigAssembler.class);

    SysConfigDTO toSysConfigDTO(SysConfig sysConfig);

    SysConfigReqDTO toSysConfigReqDTO(SysConfigRequest sysConfigRequest);

    SysConfigResponse toSysConfigResponse(SysConfigDTO sysConfigDTO);

    SysConfig toSysConfig(SysConfigDTO sysConfigDTO);

    SysConfig toSysConfig(SysConfigReqDTO sysConfigReqDTO);

}
