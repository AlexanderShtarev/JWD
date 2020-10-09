package com.epam.jwd.decorator;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.factory.FigureFactory;
import com.epam.jwd.model.factory.FigureType;
import com.epam.jwd.service.FigurePostProcessor;

public class PostProcessingFactory extends FigureFactoryDecorator {
    private final FigurePostProcessor figurePostProcessor;

    public PostProcessingFactory(FigureFactory figureFactory, FigurePostProcessor figurePostProcessor) {
        super(figureFactory);
        this.figurePostProcessor = figurePostProcessor;
    }

    @Override
    public Figure createFigure(FigureType type, Point[] figureConstituents) throws FigureException {
        Figure figure = super.createFigure(type, figureConstituents);
        Figure process = figurePostProcessor.process(figure);
        return process;
    }
}
