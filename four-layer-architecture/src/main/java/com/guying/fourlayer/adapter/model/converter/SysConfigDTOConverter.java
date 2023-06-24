package com.guying.fourlayer.adapter.model.converter;

import org.mapstruct.factory.Mappers;

/**
 * @author Code Farmer
 * @date current time
 */
public interface SysConfigDTOConverter {
    SysConfigDTOConverter INSTANCE = Mappers.getMapper(SysConfigDTOConverter.class);
}
