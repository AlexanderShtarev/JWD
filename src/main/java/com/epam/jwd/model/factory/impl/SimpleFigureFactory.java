package com.epam.jwd.model.factory.impl;

import com.epam.jwd.model.*;
import com.epam.jwd.model.factory.FigureFactory;
import com.epam.jwd.model.factory.FigureType;
import com.epam.jwd.strategy.impl.SquareStrategy;

import static com.epam.jwd.strategy.impl.LineStrategy.line_strategy_instance;
import static com.epam.jwd.strategy.impl.MultiAngleStrategy.multi_angle_strategy_instance;
import static com.epam.jwd.strategy.impl.TriangleStrategy.triangle_strategy_instance;

public class SimpleFigureFactory implements FigureFactory {
    static final SimpleFigureFactory SIMPLE_FIGURE_FACTORY = new SimpleFigureFactory();

    private SimpleFigureFactory() {
    }

    public Figure createFigure(FigureType figureType, Point[] figureConstituents) {
        Figure toReturn;
        switch (figureType) {
            case LINE:
                toReturn = Line.createModel("Line", line_strategy_instance, figureConstituents);
                break;
            case TRIANGLE:
                toReturn = Triangle.createModel("Triangle", triangle_strategy_instance, figureConstituents);
                break;
            case SQUARE:
                toReturn = Square.createModel("Square", SquareStrategy.getInstance(), figureConstituents);
                break;
            case MULTI_ANGLE_FIGURE:
                toReturn = MultiAngleFigure.createModel("MultiAngle", multi_angle_strategy_instance, figureConstituents);
                break;
            default:
                throw new IllegalArgumentException("Wrong Figure type:" + figureType);
        }
        return toReturn;
    }
}
