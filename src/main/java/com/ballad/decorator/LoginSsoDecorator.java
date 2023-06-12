package com.ballad.decorator;

import com.ballad.decorator.interceptor.HandlerInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: ANiMA
 * @date: 2022.07.02
 * @comment: 单点登录装饰器
 * 在具体的装饰类实现中，继承了装饰类SsoDecorator，那么现在就可以扩展方法：preHandle，
 */
public class LoginSsoDecorator extends SsoDecorator {

    private final Logger logger = LoggerFactory.getLogger(LoginSsoDecorator.class);
    private static final Map<String, String> AUTH_MAP = new ConcurrentHashMap<>();

    static {
        AUTH_MAP.put("huahua", "queryUserInfo");
        AUTH_MAP.put("doudou", "queryUserInfo");
    }

    public LoginSsoDecorator(HandlerInterceptor handlerInterceptor) {
        super(handlerInterceptor);
    }


    /**
     * 此处给出的是装饰者模式的核心实现方法
     * 所谓装饰着模式，即给在原有逻辑的基础之上添加新的逻辑的同时，实现高扩展。
     * 在preHandle方法的实现中我们可以看到，这里只关心扩展部分的功能，同时不会影响原有类的核心服务，
     * 也不会因为使用继承方式而导致多余的子类，增加了整体的灵活性。
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(String request, String response, Object handler) {
        //首先执行超类的校验方法
        boolean success = super.preHandle(request, response, handler);
        if (!success) {
            return false;
        }
        String userId = request.substring(8);
        String method = AUTH_MAP.get(userId);
        logger.info("模拟单点登录方法访问拦截校验{} {}", userId, method);
        // 然后模拟继承类的校验方法
        return "queryUserInfo".equals(method);
    }


}