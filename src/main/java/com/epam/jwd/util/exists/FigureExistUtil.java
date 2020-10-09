package com.epam.jwd.util.exists;

import com.epam.jwd.model.Point;
import com.epam.jwd.model.factory.FigureType;

public abstract class FigureExistUtil {
    public static boolean exists(FigureType type, Point[] figureConstituents) {
        boolean isExist = false;
        switch (type) {
            case LINE:
                isExist = LineExistUtil.exists(figureConstituents);
                break;
            case TRIANGLE:
                isExist = TriangleExistUtil.exists(figureConstituents);
                break;
            case SQUARE:
                isExist = SquareExistUtil.exists(figureConstituents);
                break;
            case MULTIANGLEFIGURE:
                isExist = MultiAngleExistUtil.exists(figureConstituents);
                break;
            default:
                throw new IllegalArgumentException("Wrong Figure type:" + type);
        }
        return isExist;
    }
}
