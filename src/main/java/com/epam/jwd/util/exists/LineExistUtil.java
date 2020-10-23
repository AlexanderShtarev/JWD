package com.epam.jwd.util.exists;

import com.epam.jwd.model.Point;
import com.epam.jwd.util.CreateLineUtil;

class LineExistUtil {

    static boolean exists(Point[] figureConstituents) {
        boolean isExist;
        isExist = CreateLineUtil.CreateLine(figureConstituents[0], figureConstituents[1]) > 0;
        return isExist;
    }
}
