package com.epam.jwd.model.factory.impl;

import com.epam.jwd.decorator.PostProcessingFactory;
import com.epam.jwd.decorator.PreProcessingFactory;
import com.epam.jwd.model.factory.FigureFactory;

import static com.epam.jwd.model.factory.impl.SimpleFigureFactory.SIMPLE_FIGURE_FACTORY;
import static com.epam.jwd.service.impl.FigurePostProcessorImpl.FIGURE_POST_PROCESSOR_IMPL;
import static com.epam.jwd.service.impl.FigurePreProcessorImpl.FIGURE_PRE_PROCESSOR_IMPL;

public class ApplicationContext {
    public static FigureFactory createFigureFactory() {
        return new PostProcessingFactory(new PreProcessingFactory(SIMPLE_FIGURE_FACTORY, FIGURE_PRE_PROCESSOR_IMPL), FIGURE_POST_PROCESSOR_IMPL);
    }
}
