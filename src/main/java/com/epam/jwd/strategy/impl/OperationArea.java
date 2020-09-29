package com.epam.jwd.strategy.impl;

import com.epam.jwd.strategy.OperationStrategy;

public class OperationArea implements OperationStrategy {

    private static OperationArea OPERATION_AREA_INSTANCE;
    public static OperationArea getInstance() {
        if (OPERATION_AREA_INSTANCE == null) {
            OPERATION_AREA_INSTANCE = new OperationArea();
        }
        return OPERATION_AREA_INSTANCE;
    }

    public int doOperation(int[] points) {
        int area;
        area = points[0]*points[1];
        System.out.println(area);
        return area;
    }
}
