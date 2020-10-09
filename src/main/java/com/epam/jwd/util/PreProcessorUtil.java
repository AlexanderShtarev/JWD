package com.epam.jwd.util;

import com.epam.jwd.model.Point;

public class PreProcessorUtil {
    private static boolean isFigure = true;

    public static boolean checkFigureException(Point[] points) {
        int i = 0;
        int j = 1;
        while (i < points.length - 1) {
            while (j < points.length) {
                if ((points[i].getX() == points[j].getX()) && (points[i].getY() == points[i].getY())) {
                    isFigure = false;
                    break;
                }
                j++;
            }
            i++;
            j = i + 1;
        }
        return isFigure;
    }
}
