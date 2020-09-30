package com.epam.jwd.model;

import com.epam.jwd.model.factory.FigureTypes;
import com.epam.jwd.strategy.OperationStrategy;

public abstract class Figure {
    protected static long id;
    private FigureTypes figureType;
    private OperationStrategy figurePropertiesStrategy;
    boolean isFigure = true;
    boolean isExists = true;

    public abstract void log();

    private void setID(int id) {
        this.id = id;
    }

    public FigureTypes getType() { return figureType; }

    Figure(FigureTypes figureType, OperationStrategy figurePropertiesStrategy, Point[] figureConsistence) {
        this.figurePropertiesStrategy = figurePropertiesStrategy;
        this.figureType = figureType;
    }

    public double executeStrategy(Point[] points) {
        return figurePropertiesStrategy.doOperation(points);
    }
}
