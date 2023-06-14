package com.ballad.utils;

/**
 * @author Administrator
 * @Classname ClassLoaderUtils
 * @date 2023-06-14 21:31
 * @comment
 */
public class ClassLoaderUtils {

    /**
     * 获取args数组列表的类数组
     * @param args
     * @return
     */
    public static Class<?>[] getClazzByArgs(Object[] args) {

        Class<?>[] parameterTypes = new Class[args.length];

        for (int i = 0; i < args.length; i++) {
            parameterTypes[i] =  args[i].getClass();
        }
        return parameterTypes;
    }
}
