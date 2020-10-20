package com.epam.jwd.strategy.impl;

import com.epam.jwd.model.Point;
import com.epam.jwd.strategy.OperationStrategy;

import static com.epam.jwd.util.CreateLineUtil.CreateLine;

public final class SquareStrategy implements OperationStrategy {
    private static SquareStrategy square_strategy_instance;

    private SquareStrategy() {
    }

    public static SquareStrategy getInstance() {
        if (square_strategy_instance == null) {
            square_strategy_instance = new SquareStrategy();
        }
        return square_strategy_instance;
    }

    @Override
    public double doOperationArea(Point[] figureConstituents) {
        return CreateLine(figureConstituents[0], figureConstituents[1]) * CreateLine(figureConstituents[0], figureConstituents[1]);
    }

    @Override
    public int doOperationPerimeter(Point[] figureConstituents) {
        return CreateLine(figureConstituents[0], figureConstituents[1]) * 4;
    }
}
