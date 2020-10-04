package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.factory.Storage;
import com.epam.jwd.service.FigurePostProcessor;

public class FigurePostProcessorImpl implements FigurePostProcessor {
    @Override
    public Figure process(Figure figure) throws FigureException {
        figure.setID();
        Storage.addToStorage(figure);
        return figure;
    }
}
