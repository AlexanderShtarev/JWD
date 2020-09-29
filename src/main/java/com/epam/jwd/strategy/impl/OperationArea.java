package com.epam.jwd.strategy.impl;

import com.epam.jwd.strategy.OperationStrategy;

public class OperationArea implements OperationStrategy {

    private static OperationArea Operation_Area_Instance;

    public static OperationArea getInstance() {
        if (Operation_Area_Instance == null) {
            Operation_Area_Instance = new OperationArea();
        }
        return Operation_Area_Instance;
    }

    public int doOperation(final int[] points) {
        int area;
        area = points[0] * points[1];
        System.out.println(area);
        return area;
    }
}
