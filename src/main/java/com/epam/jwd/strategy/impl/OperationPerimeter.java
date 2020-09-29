package com.epam.jwd.strategy.impl;

import com.epam.jwd.strategy.OperationStrategy;

public class OperationPerimeter implements OperationStrategy {

    private static OperationArea OPERATION_PERIMETER_INSTANCE;
    public static OperationArea getInstance() {
        if (OPERATION_PERIMETER_INSTANCE == null) {
            OPERATION_PERIMETER_INSTANCE = new OperationArea();
        }
        return OPERATION_PERIMETER_INSTANCE;
    }

    public int doOperation(int[] points) {
        int perimeter = 0;
        int i = 0;
        while (i < points.length) {
        perimeter += points[i]; }
        System.out.println(perimeter);
        return perimeter;
    }
}
