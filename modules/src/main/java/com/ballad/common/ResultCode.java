package com.ballad.common;

/**
 * 错误码
 *
 * @author <a href="https://github.com/liyupi">...</a>
 */
public enum ResultCode implements StatusCode{

    SUCCESS(0, "ok"),
    PARAMS_ERROR(4000000, "请求参数错误"),
    NOT_LOGIN_ERROR(4010000, "未登录"),
    NO_AUTH_ERROR(4010001, "无权限"),
    USER_NOT_EXIST(4040001,"用戶不存在"),
    NOT_FOUND_ERROR(4040000, "请求数据不存在"),
    FORBIDDEN_ERROR(4030000, "禁止访问"),
    SYSTEM_ERROR(5000000, "系统内部异常"),
    TOKEN_INVALID_SIGNATURE(5001000,"无效签名"),
    TOKEN_EXPIRED(5001001,"token过期"),
    TOKEN_ALG_EXPECTION(5001002,"token算法不一致"),
    TOKEN_INVALID(5001002,"token无效"),
    TOKEN_CREATE_ERROR(5001999,"生成token失败"),
    OPERATION_ERROR(50001, "操作失败"),
    RESPONSE_PACK_ERROR(1003, "response返回包装失败");

    /**
     * 状态码
     */
    private final int code;

    /**
     * 信息
     */
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
