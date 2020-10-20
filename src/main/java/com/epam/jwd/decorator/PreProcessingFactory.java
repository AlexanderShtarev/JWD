package com.epam.jwd.decorator;

import com.epam.jwd.exception.FigureException;
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
    private static Logger log = LoggerFactory.getLogger(PreProcessingFactory.class);

    public PreProcessingFactory(FigureFactory figureFactory, List<FigurePreProcessor> preProcessors) {
        super(figureFactory);
        PreProcessingFactory.preProcessors = preProcessors;
    }

    public static void addPreProcesses(FigurePreProcessor figurePreProcessor) {
        if (figurePreProcessor != null) {
            preProcessors.add(figurePreProcessor);
        } else {
            log.warn("You can't add null as a PreProcessor");
        }
    }

    public static void removePreProcesses(FigurePreProcessor figurePreProcessor) {
        preProcessors.remove(figurePreProcessor);
    }

    public static List<FigurePreProcessor> getPreProcesses() {
        return preProcessors;
    }

    @Override
    public Figure createFigure(FigureType type, Point[] figureConstituents) throws FigureException {
        List<Figure> preProcessorFigures = new ArrayList<>();
        preProcessors.forEach(preProcessor -> {
            try {
                preProcessorFigures.add(preProcessor.process(type, figureConstituents));
            } catch (FigureException e) {
                e.printStackTrace();
            }
        });
        if (preProcessorFigures.get(0) != null) {
            return preProcessorFigures.get(0);
        }
        return super.createFigure(type, figureConstituents);
    }
}
