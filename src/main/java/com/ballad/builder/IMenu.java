package com.ballad.builder;

/**
 * 所有接口方法返回类型均为接口本身，此为一种链式编程设计。
 * 而所谓接口名：菜单，就是各种物料的排列组合，但并非是全排列全组合
 * 接口提供的是将各元件组合到一起的方法，至于是什么元件，由生产产品的调用者决定
 *
 * @author Administrator
 * @Classname IMenu
 * @date 2023-06-20 20:15
 * @comment
 */
public interface IMenu {

    IMenu appendCeiling(Matter matter); // 吊顶

    IMenu appendCoat(Matter matter); // 涂料

    IMenu appendFloor(Matter matter); // 地板

    IMenu appendTile(Matter matter); // 地砖

    String getDetail(); // 描述

}
