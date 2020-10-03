package com.epam.jwd.service;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.factory.FigureType;

public interface FigurePreProcessor {
    Figure process(FigureType type, Point[] points) throws FigureException;
}
