package com.epam.jwd.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Line extends Figure {
    private static Logger log = LoggerFactory.getLogger(Line.class);
    private static Line singletonLine = null;

    private int a;
    private int b;
    private int line;

    public static Line getInstance( int a, int b) {
        if(singletonLine == null) {
            singletonLine = new Line( a, b);
        } return singletonLine;
    }

    public Line( int a, int b) {
        this.a = a;
        this.b = b;
        line = Math.abs(a - b);
    }
    private void exists() {
        ifExists = (a!=b);
    }
    public void log() {
        exists();
        if (ifExists) {
            log.info(toString());
        } else {
            log.error(toString());
        }
    }

    @Override
    public String toString() {
        if (ifExists) {
            return (""+line);
        } else {
            return ("Объект не является фигурой");
        }
    }
}
