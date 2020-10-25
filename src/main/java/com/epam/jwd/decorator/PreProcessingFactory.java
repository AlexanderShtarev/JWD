package com.epam.jwd.decorator;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.factory.FigureFactory;
import com.epam.jwd.model.factory.FigureType;
import com.epam.jwd.service.FigurePreProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class PreProcessingFactory extends FigureFactoryDecorator {
    private static List<FigurePreProcessor> preProcessors = new ArrayList<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(PreProcessingFactory.class);

    public PreProcessingFactory(FigureFactory figureFactory, List<FigurePreProcessor> preProcessors) {
        super(figureFactory);
        PreProcessingFactory.preProcessors = preProcessors;
    }

    public static void addPreProcesses(FigurePreProcessor figurePreProcessor) {
        if (figurePreProcessor == null) {
            LOGGER.error("PreProcessor should not be null");
            throw new IllegalArgumentException();
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
            try {
                preProcessorFigure = preProcessor.process(type, figureConstituents);
            } catch (FigureNotExistException e) {
                LOGGER.error("Figure can't exist");
            } catch (FigureException e) {
                LOGGER.error("Object can't be a figure");
            }
        }
        if (preProcessorFigure != null) {
            return preProcessorFigure;
        }
        return super.createFigure(type, figureConstituents);
    }
}
