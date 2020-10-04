package com.epam.jwd.model;

import com.epam.jwd.strategy.impl.TriangeStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Triangle extends Figure {
    private static Logger log = LoggerFactory.getLogger(Triangle.class);

    public static Triangle createTriangle(String name, TriangeStrategy figurePropertiesStrategy, Point[] figureConstituents) {
        return new Triangle(name, figurePropertiesStrategy, figureConstituents);
    }

    private Triangle(String name, TriangeStrategy figurePropertiesStrategy, Point[] figureConstituents) {
        super(name, figurePropertiesStrategy, figureConstituents);
    }

    public void log() {
        log.info(toString());
    }

    @Override
    public Point[] getModel() {
        return figureConstituents;
    }

    @Override
    public String toString() {
        return Arrays.toString(figureConstituents);
    }
}
