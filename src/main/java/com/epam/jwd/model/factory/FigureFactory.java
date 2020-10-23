package com.epam.jwd.model.factory;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;

public interface FigureFactory {
    Figure createFigure(FigureType type, Point[] figureConstituents) throws FigureException;
}
