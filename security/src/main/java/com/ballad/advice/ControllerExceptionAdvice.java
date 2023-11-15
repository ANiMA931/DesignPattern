package com.ballad.advice;

import com.ballad.common.BaseResponse;
import com.ballad.common.ResultCode;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionAdvice {
    @ExceptionHandler({BindException.class})
    public BaseResponse<String> MethodArgumentNotValidExceptionHandler(BindException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return new BaseResponse<>(ResultCode.PARAMS_ERROR, objectError.getDefaultMessage());
    }
}
