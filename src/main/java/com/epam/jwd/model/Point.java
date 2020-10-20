package com.epam.jwd.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Point {
    private static Logger log = LoggerFactory.getLogger(Point.class);

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void log() {
        log.info(toString());
    }

    @Override
    public String toString() {
        return "{" + x + " ; " + y + "}";
    }
}
