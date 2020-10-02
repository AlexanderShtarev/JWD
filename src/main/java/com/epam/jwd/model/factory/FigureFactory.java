package com.epam.jwd.model.factory;

import com.epam.jwd.model.*;

import static com.epam.jwd.strategy.impl.LineStrategy.LINE_STRATEGY_INSTANCE;
import static com.epam.jwd.strategy.impl.MultiAngleStrategy.MULTIANGLE_STRATEGY_INSTANCE;
import static com.epam.jwd.strategy.impl.SquareStrategy.getInstance;
import static com.epam.jwd.strategy.impl.TriangeStrategy.TRIANGLE_STRATEGY_INSTANCE;

public class FigureFactory {

    public final static FigureFactory FACTORY = new FigureFactory();

    private FigureFactory() {
    }

    public Figure createFigure(FigureTypes type, Point[] figureConstituents) {
        Figure toReturn = null;
        switch (type) {
            case LINE:
                toReturn = new Line(type, LINE_STRATEGY_INSTANCE, figureConstituents);
                break;
            case TRIANGLE:
                toReturn = new Triangle(type, TRIANGLE_STRATEGY_INSTANCE, figureConstituents);
                break;
            case SQUARE:
                toReturn = new Square(type, getInstance(), figureConstituents);
                break;
            case MULTIANGLEFIGURE:
                toReturn = new MultiAngleFigure(type, MULTIANGLE_STRATEGY_INSTANCE, figureConstituents);
                break;
            default:
                throw new IllegalArgumentException("Wrong Figure type:" + type);
        }
        return toReturn;
    }
}
