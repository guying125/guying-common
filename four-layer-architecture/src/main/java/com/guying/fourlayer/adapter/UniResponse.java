package com.guying.fourlayer.adapter;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 当前工程的统一响应。
 * 可以统一使用其他现有的
 *
 * @author Code Farmer
 * @since current time
 */
@Accessors(chain = true)
@Data
public class UniResponse<T> implements Serializable {
    private static final long serialVersionUID = -5333830608043194078L;

    private Boolean success;
    private String errCode = "";
    private String errMsg = "";
    private T data;

    public UniResponse(final Boolean success) {
        this.success = success;
    }

    public UniResponse(final Boolean success, final String errCode, final String errMsg) {
        this.success = success;
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public static <T> UniResponse<T> buildSuccess() {
        return new UniResponse<>(Boolean.TRUE);
    }

    public static <T> UniResponse<T> buildFailure() {
        return new UniResponse<>(Boolean.FALSE);
    }

    public UniResponse(Boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public static <T> UniResponse<T> buildFailure(final String errCode, final String errMsg) {
        return new UniResponse<>(Boolean.FALSE, errCode, errMsg);
    }

    public static <T> UniResponse<T> of(T data) {
        return new UniResponse<T>(Boolean.TRUE, data);
    }

}
