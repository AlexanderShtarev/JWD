package com.epam.jwd.strategy.impl;

import com.epam.jwd.model.Point;
import com.epam.jwd.strategy.OperationStrategy;

public class OperationSquareArea implements OperationStrategy {
    public static OperationSquareArea OPERATION_SQUAREAREA_INSTANCE = new OperationSquareArea();
    @Override
    public double doOperation(Point[] figureConsistence) {
        double area = figureConsistence[0].getX()*figureConsistence[1].getX();
        return area;
    }
}
