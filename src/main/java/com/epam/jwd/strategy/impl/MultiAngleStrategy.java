package com.epam.jwd.strategy.impl;

import com.epam.jwd.model.Point;
import com.epam.jwd.strategy.OperationStrategy;

public class MultiAngleStrategy implements OperationStrategy {
    public final static MultiAngleStrategy MULTIANGLE_STRATEGY_INSTANCE = new MultiAngleStrategy();

    @Override
    public double doOperationArea(Point[] figureConstituents) {
        return figureConstituents[0].getX() * figureConstituents[1].getX();
    }

    @Override
    public int doOperationPerimeter(Point[] figureConstituents) {
        int perimeter = 0;
        for (Point point : figureConstituents) {
            perimeter += point.getX();
        }
        return perimeter;
    }
}
