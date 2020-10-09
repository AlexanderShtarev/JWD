package com.epam.jwd.model;

import com.epam.jwd.strategy.OperationStrategy;

public abstract class Figure {
    private static int id;
    private int figureID;
    protected String name;
    private final OperationStrategy figurePropertiesStrategy;
    public Point[] figureConstituents;

    public abstract void log();

    public boolean hasID() {
        return figureID > 0;
    }

    public void setID() {
        this.figureID = ++id;
    }

    int getID() {
        return figureID;
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
