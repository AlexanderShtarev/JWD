package com.epam.jwd.model;

import com.epam.jwd.strategy.OperationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Triangle extends Figure {
    private static final Logger log = LoggerFactory.getLogger(Triangle.class);

    public static Triangle createModel(String name, OperationStrategy figurePropertiesStrategy, Point[] figureConstituents) {
        return new Triangle(name, figurePropertiesStrategy, figureConstituents);
    }

    private Triangle(String name, OperationStrategy figurePropertiesStrategy, Point[] figureConstituents) {
        super(name, figurePropertiesStrategy, figureConstituents);
    }

    public void log() {
        log.info(toString());
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", ID: " + getID() + ", Points: " + Arrays.toString(figureConstituents);
    }
}