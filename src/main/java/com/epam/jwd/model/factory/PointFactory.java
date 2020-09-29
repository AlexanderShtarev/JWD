package com.epam.jwd.model.factory;

import com.epam.jwd.model.Point;

public class PointFactory {

    public Point createFigure(int x) {
        return new Point(x);
    }
}
