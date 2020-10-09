package com.epam.jwd.util;

import com.epam.jwd.model.*;
import com.epam.jwd.model.factory.FigureType;

public class FigureLengthExceptionUtil {
    public static boolean checkFigureLength(FigureType type, Point[] points) {
        boolean toReturn;
        switch (type) {
            case LINE:
                toReturn = points.length == 2;
                break;
            case TRIANGLE:
                toReturn = points.length == 3;
                break;
            case SQUARE:
                toReturn = points.length == 4;
                break;
            case MULTIANGLEFIGURE:
                toReturn = ((points.length >= 4) && (points.length <= 6));
                break;
            default:
                throw new IllegalArgumentException("Wrong Figure type:" + type);
        }
        return toReturn;
    }
}
