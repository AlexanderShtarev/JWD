package com.epam.jwd.model.factory;

import com.epam.jwd.model.Point;

public class PointFactory {
    public final static PointFactory POINT_FACTORY = new PointFactory();

    public Point createFigure(final int x) {
        return new Point(x);
    }
}
