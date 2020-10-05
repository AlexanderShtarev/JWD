package com.epam.jwd.strategy.impl;

import com.epam.jwd.model.Point;
import com.epam.jwd.strategy.OperationStrategy;

public class SquareStrategy implements OperationStrategy {
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
        int a = Math.abs(figureConstituents[0].getX() - figureConstituents[1].getX());
        return a * a;
    }

    @Override
    public int doOperationPerimeter(Point[] figureConstituents) {
        int a = Math.abs(figureConstituents[0].getX() - figureConstituents[1].getX());
        return a * 4;
    }
}
