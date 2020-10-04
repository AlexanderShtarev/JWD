package com.epam.jwd.model;

import com.epam.jwd.strategy.impl.SquareStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Square extends Figure {
    private static Logger log = LoggerFactory.getLogger(Square.class);

    public static Square createSquare(String name, SquareStrategy figurePropertiesStrategy, Point[] figureConstituents) {
        return new Square(name, figurePropertiesStrategy, figureConstituents);
    }

    private Square(String name, SquareStrategy figurePropertiesStrategy, Point[] figureConstituents) {
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
