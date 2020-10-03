package com.epam.jwd.model;

import com.epam.jwd.model.factory.FigureType;
import com.epam.jwd.strategy.OperationStrategy;

public abstract class Figure {
    private static long id;
    protected FigureType figureType;
    protected Point[] figureConstituents;
    private String name;
    private OperationStrategy figurePropertiesStrategy;

    public abstract void log();

    public void setID() {
        id++;
    }

    Figure(String name, OperationStrategy figurePropertiesStrategy, Point[] figureConstituents) {
        this.figurePropertiesStrategy = figurePropertiesStrategy;
        this.name = name;
        this.figureConstituents = figureConstituents;
    }

    public double executeAreaStrategy() {
        return figurePropertiesStrategy.doOperationArea(figureConstituents);
    }

    public int executePerimeterStrategy() {
        return figurePropertiesStrategy.doOperationPerimeter(figureConstituents);
    }

    public Point[] getModel() {
        return figureConstituents;
    }
}
