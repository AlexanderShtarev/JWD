package com.epam.jwd.model;

import com.epam.jwd.model.factory.FigureTypes;
import com.epam.jwd.strategy.OperationStrategy;

public abstract class Figure {
    protected static long id;
    private FigureTypes figureType;
    private OperationStrategy figurePropertiesStrategy;
    boolean isFigure = true;
    boolean isExists = true;
    private Point[] figureConstituents;

    public abstract void log();

    private void setID(int id) {
        this.id = id;
    }

    public FigureTypes getType() {
        return figureType;
    }

    public abstract boolean exists();

    Figure(FigureTypes figureType, OperationStrategy figurePropertiesStrategy, Point[] figureConstituents) {
        this.figurePropertiesStrategy = figurePropertiesStrategy;
        this.figureType = figureType;
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
