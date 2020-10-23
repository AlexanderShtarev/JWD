package com.epam.jwd.decorator;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.factory.FigureFactory;
import com.epam.jwd.model.factory.FigureType;
import com.epam.jwd.service.FigurePostProcessor;

import java.util.ArrayList;
import java.util.List;

public class PostProcessingFactory extends FigureFactoryDecorator {
    private static List<FigurePostProcessor> postProcessors = new ArrayList<>();

    public PostProcessingFactory(FigureFactory figureFactory, List<FigurePostProcessor> postProcessors) {
        super(figureFactory);
        PostProcessingFactory.postProcessors = postProcessors;
    }

    public static void addPostProcesses(FigurePostProcessor figurePostProcessor) {
        if (figurePostProcessor == null) {
            throw new IllegalArgumentException("Processor should not be null");
        }
        postProcessors.add(figurePostProcessor);
    }

    public static void removePostProcesses(FigurePostProcessor figurePostProcessor) {
        postProcessors.remove(figurePostProcessor);
    }

    public static List<FigurePostProcessor> getPostProcesses() {
        return postProcessors;
    }

    @Override
    public Figure createFigure(FigureType type, Point[] figureConstituents) throws FigureException {
        Figure figure = super.createFigure(type, figureConstituents);
        for (FigurePostProcessor postProcessor : postProcessors) {
            postProcessor.process(figure);
        }
        return figure;
    }
}
