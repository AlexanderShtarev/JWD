package com.epam.jwd.service.impl;

import com.epam.jwd.model.Point;
import com.epam.jwd.model.factory.FigureType;

public class MultiCreateFigureContext {
    private final FigureType figureType;
    private final Point[] figureConstituents;

    public MultiCreateFigureContext(final FigureType figureType, final Point[] figureConstituents) {
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
