package com.epam.jwd.model;

import com.epam.jwd.strategy.impl.LineStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Line extends Figure {
    private static Logger log = LoggerFactory.getLogger(Line.class);

    public static Line createLine(String name, LineStrategy figurePropertiesStrategy, Point[] figureConstituents) {
        return new Line(name, figurePropertiesStrategy, figureConstituents);
    }

    private int line;

    private Line(String name, LineStrategy figurePropertiesStrategy, Point[] figureConstituents) {
        super(name, figurePropertiesStrategy, figureConstituents);
        line = Math.abs(figureConstituents[0].getX() - figureConstituents[1].getX());
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
        return "Name: " + name + " ID: " + figureID + " Length: " + line;
    }
}
