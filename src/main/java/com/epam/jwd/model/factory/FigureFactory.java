package com.epam.jwd.model.factory;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.*;
import com.epam.jwd.service.impl.FigurePostProcessorImpl;
import com.epam.jwd.service.impl.FigurePreProcessorImpl;
import com.epam.jwd.strategy.impl.SquareStrategy;

import static com.epam.jwd.model.Line.createLine;
import static com.epam.jwd.model.MultiAngleFigure.createMultiAngle;
import static com.epam.jwd.model.Square.createSquare;
import static com.epam.jwd.model.Triangle.createTriangle;
import static com.epam.jwd.strategy.impl.LineStrategy.LINE_STRATEGY_INSTANCE;
import static com.epam.jwd.strategy.impl.MultiAngleStrategy.MULTIANGLE_STRATEGY_INSTANCE;
import static com.epam.jwd.strategy.impl.TriangeStrategy.TRIANGLE_STRATEGY_INSTANCE;

public class FigureFactory {
    public final static FigureFactory FIGURE_FACTORY = new FigureFactory();

    private FigureFactory() {
    }

    public Figure createFigure(FigureType figureType, Point[] figureConstituents) throws FigureException {
        Figure toReturn = new FigurePreProcessorImpl().process(figureType, figureConstituents);
        if (toReturn != null) {
            return toReturn;
        }
        switch (figureType) {
            case LINE:
                toReturn = createLine("Line", LINE_STRATEGY_INSTANCE, figureConstituents);
                break;
            case TRIANGLE:
                toReturn = createTriangle("Triangle", TRIANGLE_STRATEGY_INSTANCE, figureConstituents);
                break;
            case SQUARE:
                toReturn = createSquare("Square", SquareStrategy.getInstance(), figureConstituents);
                break;
            case MULTIANGLEFIGURE:
                toReturn = createMultiAngle("MultiAngleFigure", MULTIANGLE_STRATEGY_INSTANCE, figureConstituents);
                break;
            default:
                throw new IllegalArgumentException("Wrong Figure type:" + figureType);
        }
        new FigurePostProcessorImpl().process(toReturn);
        return toReturn;
    }
}
