package com.ballad.factory;

import com.ballad.factory.impl.Circle;
import com.ballad.factory.impl.Rectangle;
import com.ballad.factory.impl.Square;

public class MyShapeFactory {


    /**
     * 使用 getShape 方法获取形状类型的对象
     * 使用对应的名称获取对应的子类
     * @param shapeType
     * @return
     */
    public MyShape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(ShapeConstant.CIRCLE.equalsIgnoreCase(shapeType)){
            return new Circle();
        } else if(ShapeConstant.RECTANGLE.equalsIgnoreCase(shapeType)){
            return new Rectangle();
        } else if(ShapeConstant.SQUARE.equalsIgnoreCase(shapeType)){
            return new Square();
        }
        return null;
    }
}
