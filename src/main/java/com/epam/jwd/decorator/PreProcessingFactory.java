package com.epam.jwd.decorator;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.factory.FigureFactory;
import com.epam.jwd.model.factory.FigureType;
import com.epam.jwd.service.FigurePreProcessor;

import java.util.*;

public class PreProcessingFactory extends FigureFactoryDecorator {
    private static List<FigurePreProcessor> preProcessors = new ArrayList<>();

    public PreProcessingFactory(FigureFactory figureFactory, List<FigurePreProcessor> preProcessors) {
        super(figureFactory);
        PreProcessingFactory.preProcessors = preProcessors;
    }

    public static void addPreProcesses(FigurePreProcessor figurePreProcessor) {
        if (figurePreProcessor == null) {
            throw new IllegalArgumentException("Processor should not be null");
        }
        preProcessors.add(figurePreProcessor);
    }

    public static void removePreProcesses(FigurePreProcessor figurePreProcessor) {
        preProcessors.remove(figurePreProcessor);
    }

    public static List<FigurePreProcessor> getPreProcesses() {
        return preProcessors;
    }

    @Override
    public Figure createFigure(FigureType type, Point[] figureConstituents) throws FigureException {
        Figure preProcessorFigure = null;
        for (FigurePreProcessor preProcessor : preProcessors) {
            preProcessorFigure = preProcessor.process(type, figureConstituents);
        }
        if (preProcessorFigure != null) {
            return preProcessorFigure;
        }
        return super.createFigure(type, figureConstituents);
    }
}
