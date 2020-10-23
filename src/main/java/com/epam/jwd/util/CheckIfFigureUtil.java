package com.epam.jwd.util;

import com.epam.jwd.model.Point;

public class CheckIfFigureUtil {

    public static boolean checkIfFigure(Point[] points) {
        for (int i = 1; i < points.length; i++) {
            if (points[i - 1].equals(points[i])) {
                return false;
            }
        }
        return true;
    }
}
