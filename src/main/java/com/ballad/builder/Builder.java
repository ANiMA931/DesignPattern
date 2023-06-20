package com.ballad.builder;

import com.ballad.builder.ceilling.LevelOneCeiling;
import com.ballad.builder.ceilling.LevelTwoCeiling;
import com.ballad.builder.coat.DuluxCoat;
import com.ballad.builder.coat.LiBangCoat;
import com.ballad.builder.floor.ShengXiangFloor;
import com.ballad.builder.tile.DongPengTile;
import com.ballad.builder.tile.MarcoPoloTile;

/**
 * 建造者本身，提供了三种产品方案
 *
 * @author Administrator
 * @Classname Builder
 * @date 2023-06-20 20:15
 * @comment
 */
public class Builder {

    /**
     * 一类产品方案
     * @param area
     * @return
     */
    public IMenu levelOne(Double area) {
        return new DecorationPackageMenu(area, "豪华欧式")
                // 吊顶：二级顶
                .appendCeiling(new LevelTwoCeiling())
                // 涂料：多乐士
                .appendCoat(new DuluxCoat())
                // 地板：圣象
                .appendFloor(new ShengXiangFloor());
    }

    /**
     * 二类产品方案
     * @param area
     * @return
     */
    public IMenu levelTwo(Double area) {
        return new DecorationPackageMenu(area, "轻奢田园")
                // 吊顶：二级顶
                .appendCeiling(new LevelTwoCeiling())
                // 涂料：立邦
                .appendCoat(new LiBangCoat())
                // 地板：马可波罗
                .appendTile(new MarcoPoloTile());
    }

    /**
     * 三类产品方案
     * @param area
     * @return
     */
    public IMenu levelThree(Double area) {
        return new DecorationPackageMenu(area, "现代简约")
                // 吊顶：一级顶
                .appendCeiling(new LevelOneCeiling())
                // 涂料：立邦
                .appendCoat(new LiBangCoat())
                // 地板：东鹏
                .appendTile(new DongPengTile()); 
    }
}
