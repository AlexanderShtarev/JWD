package com.epam.jwd.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiAngleFigure extends Figure {
    private static Logger log = LoggerFactory.getLogger(MultiAngleFigure.class);
    private int[] multiAngleFigurePoints;

    public MultiAngleFigure(int[] points) {
        multiAngleFigurePoints = new int[points.length];
        int i = 0;
        while (i < points.length) {
            multiAngleFigurePoints[i] = points[i];
            i++;
        }
    }

    public void log() {
        log.info(toString());
    }

    @Override
    public String toString() {
        String print = "";
        for (int multiAngleFigurePoint : multiAngleFigurePoints) {
            print += multiAngleFigurePoint + " ";
        }
        return print;
    }
}