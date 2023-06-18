package com.guying.msgcenter.enums;

import lombok.Getter;

/**
 * 反馈状态：已反馈、待反馈、未反馈、反馈暂存、反馈撤销、已超过反馈时间/反馈已过期
 *
 * @author Code Farmer
 */
public enum FeedbackStatusEnum {
    /**
     * 已反馈
     */
    FEEDBACK_PROVIDED("feedback_provided", "已反馈"),
    /**
     * 待反馈
     */
    PENDING_FEEDBACK("pending_feedback", "待反馈"),
    /**
     * 未反馈
     */
    NOT_FEEDBACK("not_feedback", "未反馈"),
    /**
     * 反馈暂存
     */
    FEEDBACK_STAGING("feedback_staging", "反馈暂存"),
    /**
     * 反馈撤销
     */
    FEEDBACK_CANCEL("feedback_cancel", "反馈撤销"),
    /**
     * 已超过反馈时间/反馈已过期
     */
    FEEDBACK_EXPIRED("feedback_expired", "反馈撤销");

    FeedbackStatusEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Getter
    private String code;

    @Getter
    private String name;
}
