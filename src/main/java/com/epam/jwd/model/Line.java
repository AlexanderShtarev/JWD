package com.epam.jwd.model;

import com.epam.jwd.strategy.OperationStrategy;
import com.epam.jwd.util.CreateLineUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Line extends Figure {
    private static final Logger log = LoggerFactory.getLogger(Line.class);
    private final int line;

    public static Line createModel(String name, OperationStrategy figurePropertiesStrategy, Point[] figureConstituents) {
        return new Line(name, figurePropertiesStrategy, figureConstituents);
    }

    private Line(String name, OperationStrategy figurePropertiesStrategy, Point[] figureConstituents) {
        super(name, figurePropertiesStrategy, figureConstituents);
        line = CreateLineUtil.CreateLine(figureConstituents[0], figureConstituents[1]);
    }

    public void log() {
        log.info(toString());
    }

    @Override
    public String toString() {
        return "Name: " + getNAME() + ", ID: " + getID() + ", Length: " + line;
    }
}
