package com.epam.jwd.decorator;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.factory.FigureFactory;
import com.epam.jwd.model.factory.FigureType;
import com.epam.jwd.service.FigurePostProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class PostProcessingFactory extends FigureFactoryDecorator {
    private static List<FigurePostProcessor> postProcessors = new ArrayList<>();
    private static Logger log = LoggerFactory.getLogger(PostProcessingFactory.class);

    public PostProcessingFactory(FigureFactory figureFactory, List<FigurePostProcessor> postProcessors) {
        super(figureFactory);
        PostProcessingFactory.postProcessors = postProcessors;
    }

    public static void addPostProcesses(FigurePostProcessor figurePostProcessor) {
        if (figurePostProcessor != null) {
            postProcessors.add(figurePostProcessor);
        } else {
            log.warn("You can't add null as a PostProcessor");
        }
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
        List<Figure> postProcessorFigures = new ArrayList<>();
        postProcessors.forEach(postProcessor -> {
            try {
                postProcessorFigures.add(postProcessor.process(figure));
            } catch (FigureException e) {
                e.printStackTrace();
            }
        });
        return postProcessorFigures.get(0);
    }
}
