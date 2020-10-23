package com.epam.jwd.util;

import com.epam.jwd.model.Point;

public class CreateLineUtil {
    public static int CreateLine(Point x, Point y) {
        return (int) Math.round(Math.hypot(x.getX() - y.getX(), x.getY() - y.getY()));
    }
}
