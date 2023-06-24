package com.guying.fourlayer.easycodetest.test1.application.easycodegenerate.wrapper.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 配置表(SysConfig)Response
 *
 * @author Guying
 * @since 2023-06-24 23:27:24
 */
@Accessors(chain = true)
@Data
public class SysConfigResponse implements Serializable {
    private static final long serialVersionUID = 451636053152917196L;
    /**
     * ID
     */
    private Long id;
    /**
     * 数据值
     */
    private String value;
    /**
     * 标签名
     */
    private String labelNam;
    /**
     * 类型
     */
    private String type;
    /**
     * 描述
     */
    private String descInf;
    /**
     * 排序（升序）
     */
    private BigDecimal sort;
    /**
     * 创建人
     */
    private String crtBy;
    /**
     * 创建时间
     */
    private LocalDateTime crtTim;
    /**
     * 上一次更新人
     */
    private String lstUpdBy;
    /**
     * 上一次更新时间
     */
    private LocalDateTime lstUpdTim;
    /**
     * 备注信息
     */
    private String remarks;
    /**
     * 是否删除（DELETED-已删除，NORMAL-正常）
     */
    private String delFlg;
}
