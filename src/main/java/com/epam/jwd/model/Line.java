package com.epam.jwd.model;

import com.epam.jwd.strategy.OperationStrategy;
import com.epam.jwd.util.CreateLineUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

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
        return "Name: " + getName() + ", ID: " + getID() + ", Length: " + line;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Line other = (Line) obj;
        return name.equals(other.name) && Arrays.equals(figureConstituents, other.figureConstituents)
                && (figureID == other.figureID) && (getType().equals(other.getType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + name.hashCode();
        result = prime * result + Arrays.hashCode(figureConstituents);
        return result;
    }
}