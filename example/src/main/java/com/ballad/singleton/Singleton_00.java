package com.ballad.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 这种方式在平常业务的开发中十分常见，这样的静态类的方式可以在第一次运行的时候直接初始化Map类对象，同时也不需要延迟加载再使用
 * 在不需要维持任何状态的情况下，仅仅是用作于全局访问，使用静态类的模式更加的方便
 * 但如果需要呗继承以及需要维持一些特定状态的情况下，单例模式是最好的选择
 *
 * @author Administrator
 * @Classname Singleton_00
 * @date 2023-06-15 19:07
 * @comment
 */
public class Singleton_00 {
    public static Map<String, String> cache = new ConcurrentHashMap<String, String>();
}
