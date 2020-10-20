package com.epam.jwd.strategy.impl;

import com.epam.jwd.model.Point;
import com.epam.jwd.strategy.OperationStrategy;

import static com.epam.jwd.util.CreateLineUtil.CreateLine;

public class MultiAngleStrategy implements OperationStrategy {
    public static MultiAngleStrategy multi_angle_strategy_instance = new MultiAngleStrategy();

    @Override
    public double doOperationArea(Point[] figureConstituents) {
        double area = 0;
        int j = figureConstituents.length - 1;
        int i;
        for (i = 0; i < figureConstituents.length; i++) {
            area += (figureConstituents[j].getX() + figureConstituents[i].getX()) * (figureConstituents[j].getY() - figureConstituents[i].getY());
            j = i;
        }
        return area / 2;
    }

    @Override
    public int doOperationPerimeter(Point[] figureConstituents) {
        int perimeter = 0;
        int side;
        int i = 0;
        while (i < (figureConstituents.length - 1)) {
            side = CreateLine(figureConstituents[i], figureConstituents[i + 1]);
            perimeter += side;
            i++;
        }
        int lastSide = CreateLine(figureConstituents[figureConstituents.length - 1], figureConstituents[0]);
        perimeter += lastSide;
        return perimeter;
    }
}
