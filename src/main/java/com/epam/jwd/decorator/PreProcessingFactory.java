package com.epam.jwd.decorator;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.factory.FigureFactory;
import com.epam.jwd.model.factory.FigureType;
import com.epam.jwd.service.FigurePreProcessor;

public class PreProcessingFactory extends FigureFactoryDecorator {
    private final FigurePreProcessor figurePreProcessor;

    public PreProcessingFactory(FigureFactory figureFactory, FigurePreProcessor figurePreProcessor) {
        super(figureFactory);
        this.figurePreProcessor = figurePreProcessor;
    }

    @Override
    public Figure createFigure(FigureType type, Point[] figureConstituents) throws FigureException {
        Figure preProcessorFigure = figurePreProcessor.process(type, figureConstituents);
        if (preProcessorFigure != null) {
            return preProcessorFigure;
        }
        return super.createFigure(type, figureConstituents);
    }
}
