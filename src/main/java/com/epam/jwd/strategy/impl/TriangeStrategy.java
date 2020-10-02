package com.epam.jwd.strategy.impl;

import com.epam.jwd.model.Point;
import com.epam.jwd.strategy.OperationStrategy;

public enum TriangeStrategy implements OperationStrategy {

    TRIANGLE_STRATEGY_INSTANCE;

    private double a;
    private double b;
    private double c;

    @Override
    public double doOperationArea(Point[] figureConstituents) {
        a = Math.abs(figureConstituents[0].getX() - figureConstituents[1].getX());
        b = Math.abs(figureConstituents[1].getX() - figureConstituents[2].getX());
        c = Math.abs(figureConstituents[2].getX() - figureConstituents[0].getX());
        double halfPerimeter = ((a + b + c) / 2);
        double area = Math.sqrt(halfPerimeter * ((halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c)));
        return area;
    }

    @Override
    public int doOperationPerimeter(Point[] figureConstituents) {
        a = Math.abs(figureConstituents[0].getX() - figureConstituents[1].getX());
        b = Math.abs(figureConstituents[1].getX() - figureConstituents[2].getX());
        c = Math.abs(figureConstituents[2].getX() - figureConstituents[0].getX());
        int perimeter = (int) ((int) a + b + c);
        return perimeter;
    }
}
