package com.guying.msgcenter.domain.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "sys_config")
public class SysConfig {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "VALUE")
    private String value;

    @Column(name = "LABEL_NAM")
    private String labelNam;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "DESC_INF")
    private String descInf;

    @Column(name = "SORT")
    private BigDecimal sort;

    @Column(name = "CRT_BY")
    private String crtBy;

    @Column(name = "CRT_TIM")
    private java.sql.Timestamp crtTim;

    @Column(name = "LST_UPD_BY")
    private String lstUpdBy;

    @Column(name = "LST_UPD_TIM")
    private java.sql.Timestamp lstUpdTim;

    @Column(name = "REMARKS")
    private String remarks;

    @Column(name = "DEL_FLG")
    private String delFlg;
}
