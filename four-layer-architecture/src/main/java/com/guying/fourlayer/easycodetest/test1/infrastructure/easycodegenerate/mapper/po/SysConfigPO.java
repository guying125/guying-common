package com.guying.fourlayer.easycodetest.test1.infrastructure.easycodegenerate.mapper.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 配置表(SysConfig)表 PO
 *
 * @author Guying
 * @since 2023-06-24 23:27:24
 */
@TableName(value = "sys_config")
@Accessors(chain = true)
@Data
public class SysConfigPO implements Serializable {

    private static final long serialVersionUID = -96861262043918874L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
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
