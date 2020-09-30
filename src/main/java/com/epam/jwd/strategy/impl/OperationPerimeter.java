package com.epam.jwd.strategy.impl;

import com.epam.jwd.model.Point;
import com.epam.jwd.strategy.OperationStrategy;

public class OperationPerimeter implements OperationStrategy {
    public static OperationPerimeter OPERATION_PERIMETER_INSTANCE = new OperationPerimeter();

    private OperationPerimeter(){}

    @Override
    public double doOperation(Point[] figureConsistence) {
        double perimeter = 0;
        int i = 0;
        while (i < figureConsistence.length) {
            perimeter +=figureConsistence[i].getX();
            i++;
        }
        return perimeter;
    }
}
