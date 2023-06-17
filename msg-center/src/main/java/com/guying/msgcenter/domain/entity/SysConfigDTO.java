package com.guying.msgcenter.domain.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class SysConfigDTO {
    private Long id;
    private String value;
    private String labelNam;
    private String type;
    private String descInf;
    private BigDecimal sort;
    private String crtBy;
    private java.sql.Timestamp crtTim;
    private String lstUpdBy;
    private java.sql.Timestamp lstUpdTim;
    private String remarks;
    private String delFlg;
}
