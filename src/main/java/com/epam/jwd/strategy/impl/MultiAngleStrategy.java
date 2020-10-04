package com.epam.jwd.strategy.impl;

import com.epam.jwd.model.Point;
import com.epam.jwd.strategy.OperationStrategy;

public class MultiAngleStrategy implements OperationStrategy {
    public final static MultiAngleStrategy MULTIANGLE_STRATEGY_INSTANCE = new MultiAngleStrategy();

    @Override
    public double doOperationArea(Point[] figureConstituents) {
        return 0;
    }

    @Override
    public int doOperationPerimeter(Point[] figureConstituents) {
        int perimeter = 0;
        int side;
        int i = 0;
        while (i < (figureConstituents.length - 2)) {
            side = Math.abs(figureConstituents[i].getX() - figureConstituents[i + 1].getX());
            perimeter += side;
            i++;
        }
        perimeter += Math.abs(figureConstituents[figureConstituents.length - 1].getX() - figureConstituents[0].getX());
        System.out.println(perimeter);
        return perimeter;
    }
}
