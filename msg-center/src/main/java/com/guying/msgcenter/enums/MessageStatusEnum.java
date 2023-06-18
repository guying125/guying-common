package com.guying.msgcenter.enums;

import lombok.Getter;

/**
 * 消息状态：
 * 暂存、撤回（已存储）、取消（不存储）、修改（经办修改和退回修改）、待审批、审批通过、审批拒绝、过期、生效
 *
 * @author Code Farmer
 */
public enum MessageStatusEnum {
    /**
     * 暂存状态
     */
    SAVED("saved", "暂存"),
    /**
     * 撤销/撤回已建消息
     */
    CANCEL_SAVED("cancel_saved", "撤销/撤回已建消息"),
    /**
     * 取消创建消息（首次）
     */
    CANCEL_UNSAVED("cancel_unsaved", "取消（不存储）"),
    /**
     * 修改（经办修改）
     */
    UPDATED_FOR_HANDLED("updated_for_handled", "修改（经办修改）"),
    /**
     * 修改（退回修改）
     */
    UPDATED_FOR_RETURNED("updated_for_returned", "修改（退回修改）"),
    /**
     * 待审批
     */
    PENDING_APPROVAL("pending_approval", "待审批"),
    /**
     * 审批通过
     */
    APPROVED("approved", "审批通过"),
    /**
     * 审批拒绝
     */
    APPROVAL_REJECTION("approval_rejection", "审批拒绝"),
    /**
     * 过期
     */
    EXPIRED("expired", "过期"),
    /**
     * 生效
     */
    EFFECTIVE("effective", "生效");

    MessageStatusEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Getter
    private String code;

    @Getter
    private String name;

}
