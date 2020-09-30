package com.epam.jwd.strategy.impl;

import com.epam.jwd.model.Point;
import com.epam.jwd.strategy.OperationStrategy;

public class OperationTriangleArea implements OperationStrategy {
    public static OperationTriangleArea OPERATION_TRIANGLEAREA_INSTANCE = new OperationTriangleArea();
    @Override
    public double doOperation(Point[] figureConsistence) {
        double triangleArea = (0.5)*(Math.abs(figureConsistence[0].getX()-figureConsistence[2].getX()));
        return triangleArea;
    }
}
