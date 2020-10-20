package com.epam.jwd.util.exists;

import com.epam.jwd.model.Point;

import static com.epam.jwd.util.CreateLineUtil.CreateLine;

class SquareExistUtil {

    public static boolean exists(Point[] figureConstituents) {
        boolean isExist;
        isExist = (CreateLine(figureConstituents[0], figureConstituents[1]) == CreateLine(figureConstituents[1], figureConstituents[2]))
                && (CreateLine(figureConstituents[2], figureConstituents[3]) == CreateLine(figureConstituents[3], figureConstituents[0]))
                || (CreateLine(figureConstituents[0], figureConstituents[1]) == CreateLine(figureConstituents[2], figureConstituents[3]))
                && (CreateLine(figureConstituents[3], figureConstituents[0]) == CreateLine(figureConstituents[3], figureConstituents[0]))
                || (CreateLine(figureConstituents[0], figureConstituents[1]) == CreateLine(figureConstituents[3], figureConstituents[0]))
                && (CreateLine(figureConstituents[1], figureConstituents[2]) == CreateLine(figureConstituents[2], figureConstituents[3]));
        return isExist;
    }
}
