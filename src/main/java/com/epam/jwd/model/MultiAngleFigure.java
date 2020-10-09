package com.epam.jwd.model;

import com.epam.jwd.strategy.OperationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class MultiAngleFigure extends Figure {
    private static final Logger log = LoggerFactory.getLogger(MultiAngleFigure.class);

    public static MultiAngleFigure createModel(String name, OperationStrategy figurePropertiesStrategy, Point[] figureConstituents) {
        return new MultiAngleFigure(name, figurePropertiesStrategy, figureConstituents);
    }

    private MultiAngleFigure(String name, OperationStrategy figurePropertiesStrategy, Point[] figureConstituents) {
        super(name, figurePropertiesStrategy, figureConstituents);
    }

    public void log() {
        log.info(toString());
    }

    @Override
    public String toString() {
        return "Name: " + name + " ID: " + getID() + " Points: " + Arrays.toString(figureConstituents);
    }
}
