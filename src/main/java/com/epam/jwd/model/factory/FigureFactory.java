package com.epam.jwd.model.factory;

import com.epam.jwd.model.*;
import com.epam.jwd.strategy.impl.SquareStrategy;

import static com.epam.jwd.strategy.impl.LineStrategy.LINE_STRATEGY_INSTANCE;
import static com.epam.jwd.strategy.impl.MultiAngleStrategy.MULTIANGLE_STRATEGY_INSTANCE;
import static com.epam.jwd.strategy.impl.TriangeStrategy.TRIANGLE_STRATEGY_INSTANCE;

public class FigureFactory {

    public final static FigureFactory FACTORY = new FigureFactory();

    private FigureFactory() {
    }

    public Figure createFigure(ENUM figureType, Point[] figureConstituents) {
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
        return toReturn;
    }
}