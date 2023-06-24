package com.guying.fourlayer.easycodetest.test1.domain.easycodegenerate.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 配置表(SysConfig)
 *
 * @author Guying
 * @since 2023-06-24 23:27:24
 */
@Accessors(chain = true)
@Data
@Builder
public class SysConfig implements Serializable {
    private static final long serialVersionUID = 218560120252320374L;
    /**
     * ID
     */
    @Column(name = "ID")
    private Long id;
    /**
     * 数据值
     */
    @Column(name = "VALUE")
    private String value;
    /**
     * 标签名
     */
    @Column(name = "LABEL_NAM")
    private String labelNam;
    /**
     * 类型
     */
    @Column(name = "TYPE")
    private String type;
    /**
     * 描述
     */
    @Column(name = "DESC_INF")
    private String descInf;
    /**
     * 排序（升序）
     */
    @Column(name = "SORT")
    private BigDecimal sort;
    /**
     * 创建人
     */
    @Column(name = "CRT_BY")
    private String crtBy;
    /**
     * 创建时间
     */
    @Column(name = "CRT_TIM")
    private LocalDateTime crtTim;
    /**
     * 上一次更新人
     */
    @Column(name = "LST_UPD_BY")
    private String lstUpdBy;
    /**
     * 上一次更新时间
     */
    @Column(name = "LST_UPD_TIM")
    private LocalDateTime lstUpdTim;
    /**
     * 备注信息
     */
    @Column(name = "REMARKS")
    private String remarks;
    /**
     * 是否删除（DELETED-已删除，NORMAL-正常）
     */
    @Column(name = "DEL_FLG")
    private String delFlg;
}
