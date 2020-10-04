package com.epam.jwd.model;

import com.epam.jwd.model.factory.FigureType;
import com.epam.jwd.strategy.OperationStrategy;

public abstract class Figure {
    private static int id = 1;
    private int figureID;
    private String name;
    private FigureType figureType;
    private OperationStrategy figurePropertiesStrategy;
    public Point[] figureConstituents;

    public abstract void log();

    public void setID() {
        this.figureID = ++id;
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
