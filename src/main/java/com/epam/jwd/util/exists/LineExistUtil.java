package com.epam.jwd.util.exists;

import com.epam.jwd.model.Point;

import static com.epam.jwd.util.CreateLineUtil.CreateLine;

public class LineExistUtil extends FigureExistUtil {

    public static boolean exists(Point[] figureConstituents) {
        boolean isExist;
        isExist = CreateLine(figureConstituents[0], figureConstituents[1]) > 0;
        return isExist;
    }
}
