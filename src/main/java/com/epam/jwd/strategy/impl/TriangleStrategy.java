package com.epam.jwd.strategy.impl;

import com.epam.jwd.model.Point;
import com.epam.jwd.strategy.OperationStrategy;
import com.epam.jwd.util.CreateLineUtil;

public enum TriangleStrategy implements OperationStrategy {

    triangle_strategy_instance;

    @Override
    public double doOperationArea(Point[] figureConstituents) {
        double a = CreateLineUtil.CreateLine(figureConstituents[0], figureConstituents[1]);
        double b = CreateLineUtil.CreateLine(figureConstituents[1], figureConstituents[2]);
        double c = CreateLineUtil.CreateLine(figureConstituents[2], figureConstituents[0]);
        double halfPerimeter = ((a + b + c) / 2);
        double area = Math.sqrt(halfPerimeter * ((halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c)));
        return area;
    }

    @Override
    public int doOperationPerimeter(Point[] figureConstituents) {
        return CreateLineUtil.CreateLine(figureConstituents[0], figureConstituents[1]) +
                CreateLineUtil.CreateLine(figureConstituents[1], figureConstituents[2]) +
                CreateLineUtil.CreateLine(figureConstituents[2], figureConstituents[0]);
    }
}
