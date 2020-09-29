package com.epam.jwd.strategy.impl;

import com.epam.jwd.strategy.OperationStrategy;

public class OperationPerimeter implements OperationStrategy {

    private static OperationArea Operation_Perimeter_Instance;

    public static OperationArea getInstance() {
        if (Operation_Perimeter_Instance == null) {
            Operation_Perimeter_Instance = new OperationArea();
        }
        return Operation_Perimeter_Instance;
    }

    public int doOperation(final int[] points) {
        int perimeter = 0;
        int i = 0;
        while (i < points.length) {
            perimeter += points[i];
        }
        System.out.println(perimeter);
        return perimeter;
    }
}
