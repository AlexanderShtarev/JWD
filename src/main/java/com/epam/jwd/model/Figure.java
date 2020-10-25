package com.epam.jwd.model;

import com.epam.jwd.model.factory.FigureType;
import com.epam.jwd.strategy.OperationStrategy;

public abstract class Figure {
    private static int id;
    private int figureID;
    private final String NAME;
    private final OperationStrategy figurePropertiesStrategy;
    protected Point[] figureConstituents;
    protected FigureType type;

    public void setID() {
        this.figureID = ++id;
    }

    public int getID() {
        return figureID;
    }

    public boolean hasID() {
        return figureID > 0;
    }

    public String getNAME() {
        return NAME;
    }

    public FigureType getType() {
        return type;
    }

    public Point[] getModel() {
        return figureConstituents;
    }

    public Figure(String name, OperationStrategy figurePropertiesStrategy, Point[] figureConstituents) {
        this.figurePropertiesStrategy = figurePropertiesStrategy;
        this.NAME = name;
        this.figureConstituents = figureConstituents;
    }

    public double executeAreaStrategy() {
        return figurePropertiesStrategy.doOperationArea(figureConstituents);
    }

    public int executePerimeterStrategy() {
        return figurePropertiesStrategy.doOperationPerimeter(figureConstituents);
    }

}
