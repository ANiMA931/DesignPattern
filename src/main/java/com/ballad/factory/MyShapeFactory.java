package com.ballad.factory;

import com.ballad.factory.impl.Circle;
import com.ballad.factory.impl.Rectangle;
import com.ballad.factory.impl.Square;

public class MyShapeFactory {
    //使用 getShape 方法获取形状类型的对象
    public MyShape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
