package com.epam.jwd.strategy.impl;

import com.epam.jwd.model.Point;
import com.epam.jwd.strategy.OperationStrategy;

public class LineStrategy implements OperationStrategy {
    public final static LineStrategy LINE_STRATEGY_INSTANCE = new LineStrategy();

    @Override
    public double doOperationArea(Point[] figureConstituents) {
        return 0;
    }

    @Override
    public int doOperationPerimeter(Point[] figureConstituents) {
        return 0;
    }
}
