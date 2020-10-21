package com.epam.jwd.service.impl;

import com.epam.jwd.model.Point;
import com.epam.jwd.model.factory.FigureType;

public class MultiCreateFigureContext {
    private FigureType figureType;
    private Point[] figureConstituents;

    public MultiCreateFigureContext(FigureType figureType, Point[] figureContituents) {
        this.figureConstituents = figureContituents;
        this.figureType = figureType;
    }
    public FigureType getType() {
        return figureType;
    }

    public Point[] getPoints() {
        return figureConstituents;
    }
}
