package com.epam.jwd.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Line extends Figura {
    static Logger log = LoggerFactory.getLogger(Line.class);

    private int a;
    private int b;
    private int line;

    public Line(final int a, final int b) {
        this.a = a;
        this.b = b;
        line = Math.abs(a - b);
    }

    public int getLine() {
        return line;
    }

    public void log() {
        log.info(toString());
    }

    @Override
    public String toString() {
        return "" + line;
    }
}
