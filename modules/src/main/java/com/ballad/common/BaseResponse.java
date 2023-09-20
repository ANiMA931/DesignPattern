package com.ballad.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用返回类
 *
 * @param <T>
 * @author <a href="https://github.com/liyupi">...</a>
 */
@Data
public class BaseResponse<T> implements Serializable {

    private int code;

    private T data;

    private String message;

    public BaseResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public BaseResponse(T data) {
        this.data = data;
        this.code = ResultCode.SUCCESS.getCode();
        this.message = ResultCode.SUCCESS.getMessage();
    }

    public BaseResponse(ResultCode resultCode, T data) {
        this.data = data;
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    // 只返回状态码
    public BaseResponse(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
        this.data = null;
    }

    public BaseResponse(int code, T data) {
        this(code, data, "");
    }

    public BaseResponse(ResultCode resultCode) {
        this(resultCode.getCode(), null, resultCode.getMessage());
    }
}
