package com.guying.msgcenter.enums;

import lombok.Getter;

/**
 * 阅读状态：已读（实际已读、标记已读）、未读、已终止
 *
 * @author QJYou
 */
public enum ReadingStatusEnum {
    /**
     * 已读（实际已读）
     */
    ACTUAL_READ("actual_read", "已读（实际已读）"),
    /**
     * 已读（标记已读）
     */
    MARKED_READ("marked_read", "已读（标记已读）"),
    /**
     * 未读
     */
    UNREAD("unread", "未读"),
    /**
     * 已终止
     */
    TERMINATED("terminated", "已终止");

    ReadingStatusEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Getter
    private String code;

    @Getter
    private String name;
}
