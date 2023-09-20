package com.ballad.common;

/**
 * 返回工具类
 *
 * @author <a href="https://github.com/liyupi">...</a>
 */
public class ResultUtils {

    /**
     * 成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(ResultCode.SUCCESS.getCode(), data, ResultCode.SUCCESS.getMessage());
    }

    public static <T> BaseResponse<T> success(T data, String message) {
        return new BaseResponse<>(ResultCode.SUCCESS.getCode(), data, message);
    }

    /**
     * 失败
     *
     * @param resultCode
     * @return
     */
    public static BaseResponse<?> error(ResultCode resultCode) {
        return new BaseResponse<>(resultCode);
    }

    /**
     * 失败
     *
     * @param code
     * @param message
     * @return
     */
    public static BaseResponse<?> error(int code, String message) {
        return new BaseResponse<>(code, null, message);
    }

    /**
     * 失败
     *
     * @param resultCode
     * @return
     */
    public static BaseResponse<?> error(ResultCode resultCode, String message) {
        return new BaseResponse<>(resultCode.getCode(), null, message);
    }
}
