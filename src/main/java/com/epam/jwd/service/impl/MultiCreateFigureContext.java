package com.epam.jwd.service.impl;

import com.epam.jwd.model.Point;
import com.epam.jwd.model.factory.FigureType;

public class MultiCreateFigureContext {
    private FigureType figureType;
    private Point[] figureConstituents;

    public MultiCreateFigureContext(FigureType figureType, Point[] figureConstituents) {
        this.figureConstituents = figureConstituents;
        this.figureType = figureType;
    }

    FigureType getType() {
        return figureType;
    }

    Point[] getPoints() {
        return figureConstituents;
    }
}
