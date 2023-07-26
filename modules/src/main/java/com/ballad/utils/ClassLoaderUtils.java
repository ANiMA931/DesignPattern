package com.ballad.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @Classname ClassLoaderUtils
 * @date 2023-06-14 21:31
 * @comment
 */
public class ClassLoaderUtils {

    /**
     * 获取args数组列表的类数组
     *
     * @param args
     * @return
     */
    public static Class<?>[] getClazzByArgs(Object[] args) {
        Class<?>[] parameterTypes = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            //如果参数是枚举，那么需要类型转换，再通过getDeclaringClass方法来获取class对象
            if (args[i] instanceof Enum) {
                parameterTypes[i] = ((Enum<?>) args[i]).getDeclaringClass();
                continue;
            }
            parameterTypes[i] = args[i].getClass();
        }
        return parameterTypes;
    }

    /**
     * 将一个object对象强制转换为list
     *
     * @param obj
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> castObjectToList(Object obj, Class<T> clazz) {
        List<T> result = new ArrayList<>();
        if (obj instanceof List<?>) {
            for (Object o : (List<?>) obj) {
                result.add(clazz.cast(o));
            }
            return result;
        }
        return null;
    }

}
