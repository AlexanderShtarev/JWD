package com.epam.jwd.model.factory;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.*;
import com.epam.jwd.service.impl.FigurePostProcessorImpl;
import com.epam.jwd.service.impl.FigurePreProcessorImpl;
import com.epam.jwd.strategy.impl.SquareStrategy;

import static com.epam.jwd.strategy.impl.LineStrategy.LINE_STRATEGY_INSTANCE;
import static com.epam.jwd.strategy.impl.MultiAngleStrategy.MULTIANGLE_STRATEGY_INSTANCE;
import static com.epam.jwd.strategy.impl.TriangeStrategy.TRIANGLE_STRATEGY_INSTANCE;

public class FigureFactory {
    public final static FigureFactory FIGURE_FACTORY = new FigureFactory();

    private FigureFactory() {
    }

    public Figure createFigure(FigureType figureType, Point[] figureConstituents) throws FigureException {
        new FigurePreProcessorImpl().process(figureType, figureConstituents);
        Figure toReturn = null;
            switch (figureType) {
                case LINE:
                    toReturn = new Line("Line", LINE_STRATEGY_INSTANCE, figureConstituents);
                    break;
                case TRIANGLE:
                    toReturn = new Triangle("Triangle", TRIANGLE_STRATEGY_INSTANCE, figureConstituents);
                    break;
                case SQUARE:
                    toReturn = new Square("Square", SquareStrategy.getInstance(), figureConstituents);
                    break;
                case MULTIANGLEFIGURE:
                    toReturn = new MultiAngleFigure("MultiAngleFigure", MULTIANGLE_STRATEGY_INSTANCE, figureConstituents);
                    break;
                default:
                    throw new IllegalArgumentException("Wrong Figure type:" + figureType);
            }
        new FigurePostProcessorImpl().process(toReturn);
        return toReturn;
    }
}