package com.epam.jwd.model;

import com.epam.jwd.model.factory.ENUM;
import com.epam.jwd.strategy.OperationStrategy;

public abstract class Figure {
    private static long id;
    String name;
    boolean isFigure = true;
    boolean isExists = true;
    private ENUM figureType;
    private OperationStrategy figurePropertiesStrategy;
    private Point[] figureConstituents;

    public abstract void log();

    private void setID(int id) {
        this.id = id;
    }

    public abstract boolean exists();

    Figure(String name, OperationStrategy figurePropertiesStrategy, Point[] figureConstituents) {
        this.figurePropertiesStrategy = figurePropertiesStrategy;
        this.name = name;
        this.figureConstituents = figureConstituents;
    }

    public double executeStrategy(Point[] figureConstituents) {
        figurePropertiesStrategy.doOperationPerimeter(figureConstituents);
        figurePropertiesStrategy.doOperationArea(figureConstituents);
        return 2;
    }

    public Point[] getModel() {
        return figureConstituents;
    }
}
