package com.ballad.abstractfactory.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author Administrator
 * @Classname JdkProxy
 * @date 2023-06-14 21:06
 * @comment
 */
public class JDKProxy {

    /**
     * 获取代理的方法
     * @param interfaceClass 具体的接口类对象
     * @param cacheAdapter 需要适配的接口
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T getProxy(Class<T> interfaceClass, ICacheAdapter cacheAdapter) throws Exception {
        //方法调用handler
        InvocationHandler handler = new JDKInvocationHandler(cacheAdapter);
        //声明类加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        //传进来的类实现了什么接口，
        Class<?>[] classes = interfaceClass.getInterfaces();
        //此处的0实际上表明该类只实现了一个接口，通过此种方法，可以获得cacheAdapter在该模式下适配的实现类
        return (T) Proxy.newProxyInstance(classLoader, new Class[]{classes[0]}, handler);
    }
}
