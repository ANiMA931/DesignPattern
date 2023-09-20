package com.ballad.exception;

import com.ballad.common.ResultCode;
import com.ballad.common.StatusCode;
import lombok.Getter;

@Getter
public class APIException extends RuntimeException {
    private int code;
    private String message;

    // 手动设置异常
    public APIException(StatusCode statusCode, String message) {
        // message用于用户设置抛出错误详情，例如：当前价格-5，小于0
        super(message);
        // 状态码
        this.code = statusCode.getCode();
        // 状态码配套的msg
        this.message = statusCode.getMessage();
    }

    // 默认异常使用APP_ERROR状态码
    public APIException(String message) {
        super(message);
        this.code = ResultCode.OPERATION_ERROR.getCode();
        this.message = ResultCode.OPERATION_ERROR.getMessage();
    }

}