package com.epam.jwd.model.factory;

import com.epam.jwd.model.*;
import com.epam.jwd.strategy.OperationStrategy;

public class FigureFactory implements Factory {

    public Figure createFigure(FigureTypes type, OperationStrategy figurePropertiesStrategy, Point[] figureConsistence) {
        Figure toReturn = null;
        switch (type) {
            case LINE:
                toReturn = new Line(type, figurePropertiesStrategy, figureConsistence);
                break;
            case TRIANGLE:
                toReturn = new Triangle(type, figurePropertiesStrategy, figureConsistence);
                break;
            case SQUARE:
                toReturn = new Square(type, figurePropertiesStrategy, figureConsistence);
                break;
            case MULTIANGLEFIGURE:
                if ((figureConsistence.length >= 4) && (figureConsistence.length <= 6)) {
                    toReturn = new MultiAngleFigure(type, figurePropertiesStrategy, figureConsistence);
                }
                break;
            default:
                throw new IllegalArgumentException("Wrong Figure type:" + type);
        }
        return toReturn;
    }
}
