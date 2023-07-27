package com.ballad.decorator.interceptor;


/**
 * @author: ANiMA
 * @date: 2022.07.04
 * @comment: handler拦截器接口类
 */
public interface HandlerInterceptor {
    /**
     * Handler拦截器的处理方法
     *
     * @param request 模拟请求
     * @param response 模拟回应
     * @param handler 模拟handler
     * @return boolean 处理前结果受否实现
     */
    boolean preHandle(String request, String response, Object handler);
}
