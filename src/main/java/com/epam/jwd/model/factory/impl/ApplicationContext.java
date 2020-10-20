package com.epam.jwd.model.factory.impl;

import com.epam.jwd.decorator.PostProcessingFactory;
import com.epam.jwd.decorator.PreProcessingFactory;
import com.epam.jwd.model.factory.FigureFactory;

import static com.epam.jwd.model.factory.impl.SimpleFigureFactory.SIMPLE_FIGURE_FACTORY;

public class ApplicationContext {
    public static FigureFactory createFigureFactory() {
        return new PostProcessingFactory(new PreProcessingFactory(SIMPLE_FIGURE_FACTORY, PreProcessingFactory.getPreProcesses()), PostProcessingFactory.getPostProcesses());
    }
}
