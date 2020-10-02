package com.epam.jwd.model;

import com.epam.jwd.strategy.OperationStrategy;
import com.epam.jwd.strategy.impl.TriangeStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Triangle extends Figure {
    private static Logger log = LoggerFactory.getLogger(Triangle.class);

    private int a;
    private int b;
    private int c;
    private Point[] figureConstituents;
    private OperationStrategy triangleStrategyInstance;

    public Triangle(String name, TriangeStrategy triangleStrategyInstance, Point[] figureConstituents) {
        super(name, triangleStrategyInstance, figureConstituents);
        this.figureConstituents = figureConstituents;
        this.name = name;
        this.triangleStrategyInstance = triangleStrategyInstance;
        this.a = Math.abs(figureConstituents[0].getX() - figureConstituents[1].getX());
        this.b = Math.abs(figureConstituents[1].getX() - figureConstituents[2].getX());
        this.c = Math.abs(figureConstituents[2].getX() - figureConstituents[0].getX());
        isFigure = ((figureConstituents[0].getX() != figureConstituents[1].getX())
                && (figureConstituents[0].getX() != figureConstituents[2].getX())
                && (figureConstituents[1].getX() != figureConstituents[2].getX()));
    }

    public boolean exists() {
        isExists = ((a < b + c) && (b < a + c) && (c < a + b));
        return (isExists) && (isFigure);
    }

    public void log() {
        exists();
        if ((isExists) && (isFigure)) {
            log.info(toString());
        } else {
            log.error(toString());
        }
    }

    public double executeStrategy(Point[] figureConstituents) {
        triangleStrategyInstance.doOperationPerimeter(figureConstituents);
        triangleStrategyInstance.doOperationArea(figureConstituents);
        return 2;
    }

    @Override
    public Point[] getModel() {
        return figureConstituents;
    }

    @Override
    public String toString() {
        String print = null;
        if ((isExists) && (isFigure)) {
            print = "Треугольник: " + a + " " + b + " " + c;
        } else if (!isExists) {
            print = "Треугольник не может существовать";
        } else {
            print = "Объект не является фигурой";
        }
        return print;
    }
}
