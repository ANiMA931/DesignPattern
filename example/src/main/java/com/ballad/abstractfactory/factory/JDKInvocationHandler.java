package com.ballad.abstractfactory.factory;

import com.ballad.utils.ClassLoaderUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Administrator
 * @Classname JDKInvocationHandler
 * @date 2023-06-14 21:06
 * @comment
 */
public class JDKInvocationHandler implements InvocationHandler {
    private final ICacheAdapter cacheAdapter;

    public JDKInvocationHandler(ICacheAdapter cacheAdapter) {
        this.cacheAdapter = cacheAdapter;
    }

    /**
     * 经典的对象方法调用
     *
     * @param proxy  对象
     * @param method 方法
     * @param args   方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //此处完成了接口方法完全相同但具体接口不同的对象方法调用
        return ICacheAdapter.class.getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args)).invoke(cacheAdapter, args);
    }
}
