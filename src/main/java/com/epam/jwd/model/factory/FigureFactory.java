package com.epam.jwd.model.factory;

import com.epam.jwd.model.*;

public class FigureFactory {
    public Figure createFigure(FigureTypes type, int[] points) {
        Figure toReturn = null;
        switch (type) {
            case LINE:
               toReturn = new Line(points[0],points[1]);
                break;
            case TRIANGLE:
                toReturn = new Triangle(points[0], points[1], points[2]);
                break;
            case SQUARE:
                toReturn = new Square(points[0], points[1], points[2], points[3]);
                break;
            case MULTIANGLEFIGURE:
                if (( points.length >= 4) && ( points.length <= 6)) {
                toReturn = new MultiAngleFigure(points); }
                break;
            default:
                throw new IllegalArgumentException("Wrong Figure type:" + type);
        }
        return toReturn;
    }
}
