package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.factory.FigureType;
import com.epam.jwd.model.factory.Storage;
import com.epam.jwd.service.FigurePreProcessor;
import com.epam.jwd.util.CheckIfFigureUtil;
import com.epam.jwd.util.exists.FigureExistUtil;

public class FigurePreProcessorImpl implements FigurePreProcessor {
    public final static FigurePreProcessorImpl FIGURE_PRE_PROCESSOR_IMPL = new FigurePreProcessorImpl();

    private FigurePreProcessorImpl() {
    }

    public Figure process(FigureType type, Point[] points) throws FigureException {
        if (!CheckIfFigureUtil.checkIfFigure(points)) {
            throw new FigureException();
        }
        if (!FigureExistUtil.exists(type, points)) {
            throw new FigureNotExistException();
        }
        return Storage.checkIfUnique(points).orElse(null);
    }
}
