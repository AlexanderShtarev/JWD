package com.epam.jwd.strategy;

import com.epam.jwd.model.Point;

public interface OperationStrategy {
    double doOperationArea(Point[] figureConstituents);

    int doOperationPerimeter(Point[] figureConstituents);
}
