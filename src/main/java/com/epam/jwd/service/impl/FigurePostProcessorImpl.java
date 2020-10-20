package com.epam.jwd.service.impl;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.factory.Storage;
import com.epam.jwd.service.FigurePostProcessor;

public class FigurePostProcessorImpl implements FigurePostProcessor {
    public final static FigurePostProcessorImpl FIGURE_POST_PROCESSOR_IMPL = new FigurePostProcessorImpl();

    private FigurePostProcessorImpl() {
    }

    @Override
    public Figure process(Figure figure) {
        if (figure.hasID()) {
            return figure;
        }
        figure.setID();
        Storage.addToStorage(figure);
        return figure;
    }
}
