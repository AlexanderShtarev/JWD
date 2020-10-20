package com.epam.jwd.util.exists;

import com.epam.jwd.model.Point;

import static com.epam.jwd.util.CreateLineUtil.CreateLine;

class MultiAngleExistUtil {
    static boolean exists(Point[] figureConstituents) {
        boolean isExist;
        int i = 0;
        int p = 0;
        while (i < figureConstituents.length - 1) {
            p += CreateLine(figureConstituents[i], figureConstituents[i + 1]);
            i++;
        }
        isExist = (p > CreateLine(figureConstituents[figureConstituents.length - 1], figureConstituents[figureConstituents.length - 1]));
        return isExist;
    }
}
