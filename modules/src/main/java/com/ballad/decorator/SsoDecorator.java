package com.ballad.decorator;

import com.ballad.decorator.interceptor.HandlerInterceptor;

/**
 * 在装饰类中，有两个重点的地方是：
 * 1) 继承了处理接口。
 * 2) 提供了构造函数。
 * 3) 覆盖了方法preHandle。
 * 以上三点是装饰器模式的核心部分，这样可以踢掉对子类继承的方式实现逻辑功能扩展。
 *
 * @author ANiMA
 */
public abstract class SsoDecorator implements HandlerInterceptor {

    private HandlerInterceptor handlerInterceptor;


    private SsoDecorator() {
    }


    public SsoDecorator(HandlerInterceptor handlerInterceptor) {
        this.handlerInterceptor = handlerInterceptor;
    }


    @Override
    public boolean preHandle(String request, String response, Object handler) {
        return handlerInterceptor.preHandle(request, response, handler);
    }

}
