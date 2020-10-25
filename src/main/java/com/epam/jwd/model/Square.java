package com.epam.jwd.model;

import com.epam.jwd.strategy.OperationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Square extends Figure {
    private static Logger log = LoggerFactory.getLogger(Square.class);

    public static Square createModel(String name, OperationStrategy figurePropertiesStrategy, Point[] figureConstituents) {
        return new Square(name, figurePropertiesStrategy, figureConstituents);
    }

    private Square(String name, OperationStrategy figurePropertiesStrategy, Point[] figureConstituents) {
        super(name, figurePropertiesStrategy, figureConstituents);
    }

    public void log() {
        log.info(toString());
    }

    @Override
    public String toString() {
        return "Name: " + getNAME() + ", ID: " + getID() + ", Points: " + Arrays.toString(figureConstituents);
    }
}
