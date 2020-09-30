package com.epam.jwd.strategy.impl;

import com.epam.jwd.model.Point;
import com.epam.jwd.strategy.OperationStrategy;

public class OperationMultiAngleFigureArea implements OperationStrategy {
    public static OperationMultiAngleFigureArea OPERATION_MULTIANGLEFIGUREAREA_INSTANCE = new OperationMultiAngleFigureArea();
    @Override
    public double doOperation(Point[] figureConsistence) {
        double area = 0;
        int i = 0;
        while (i < figureConsistence.length) {
          area += (figureConsistence[i].getX()*figureConsistence[i+1].getX())/2;
        } return area;
    }
}
