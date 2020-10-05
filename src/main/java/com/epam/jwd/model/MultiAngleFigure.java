package com.epam.jwd.model;

import com.epam.jwd.strategy.impl.MultiAngleStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class MultiAngleFigure extends Figure {
    private static Logger log = LoggerFactory.getLogger(MultiAngleFigure.class);

    public static MultiAngleFigure createMultiAngle(String name, MultiAngleStrategy figurePropertiesStrategy, Point[] figureConstituents) {
        return new MultiAngleFigure(name, figurePropertiesStrategy, figureConstituents);
    }

    private MultiAngleFigure(String name, MultiAngleStrategy figurePropertiesStrategy, Point[] figureConstituents) {
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
        return "Name: " + name + " ID: " + figureID + " Points: " + Arrays.toString(figureConstituents);
    }
}