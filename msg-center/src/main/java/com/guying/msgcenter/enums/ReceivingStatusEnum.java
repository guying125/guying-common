package com.guying.msgcenter.enums;

import lombok.Getter;

/**
 * 接收状态：
 * 已接收（已送达）、未接收（未送达）、拒接
 * Received (delivered), Not Received (undelivered), Rejected
 *
 * @author Code Farmer
 */
public enum ReceivingStatusEnum {
    /**
     * 已接收（已送达）
     */
    RECEIVED("received", "已接收"),
    /**
     * 未接收（未送达）
     */
    NOT_RECEIVED("not_received", "未接收"),
    /**
     * 拒接
     */
    REJECTED("rejected", "拒接");

    ReceivingStatusEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Getter
    private String code;

    @Getter
    private String name;
}
