package com.guying.msgcenter.enums;

import lombok.Getter;

/**
 * 发送状态：
 * 待发送、发送中、发送成功（已发送）、发送失败
 *
 * @author Code Farmer
 * @date 2023-05-30 19:07
 */
public enum SendingStatusEnum {
    /**
     * 待发送
     */
    PENDING("pending", "待发送"),
    /**
     * 发送中
     */
    SENDING("sending", "发送中"),
    /**
     * 发送成功（已发送）
     */
    SENT("sent", "发送成功（已发送）"),
    /**
     * 发送失败
     */
    SENDING_FAILED("sending_failed", "发送失败");

    SendingStatusEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Getter
    private String code;

    @Getter
    private String name;
}
