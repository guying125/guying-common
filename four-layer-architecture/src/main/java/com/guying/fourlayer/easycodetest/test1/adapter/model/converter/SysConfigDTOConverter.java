package com.guying.fourlayer.easycodetest.test1.adapter.model.converter;

import com.guying.fourlayer.easycodetest.test1.adapter.model.request.SysConfigRequest;
import com.guying.fourlayer.easycodetest.test1.adapter.model.response.SysConfigResponse;
import com.guying.fourlayer.easycodetest.test1.application.easycodegenerate.wrapper.dto.SysConfigDTO;
import com.guying.fourlayer.easycodetest.test1.application.easycodegenerate.wrapper.dto.SysConfigReqDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 配置表(SysConfig) Converter转换器
 *
 * @author Guying
 * @since 2023-06-24 23:27:23
 */
@Mapper(componentModel = "spring")
public interface SysConfigDTOConverter {
    SysConfigDTOConverter INSTANCE = Mappers.getMapper(SysConfigDTOConverter.class);

    SysConfigReqDTO toSysConfigReqDTO(SysConfigRequest sysConfigRequest);

    SysConfigResponse toSysConfigResponse(SysConfigDTO sysConfigDTO);

}
