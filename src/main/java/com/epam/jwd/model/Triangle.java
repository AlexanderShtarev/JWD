package com.epam.jwd.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Triangle extends Figura implements IExists {
    static Logger log = LoggerFactory.getLogger(Triangle.class);

    private int a;
    private int b;
    private int c;

    public Triangle(final int a, final int b, final int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean exists() {
        ifExists = ((a < b + c) && (b < a + c) && (c < a + b));
        return ifExists;
    }

    public void log() {
        exists();
        if ((ifExists)) {
            log.info(toString());
        } else {
            log.error(toString());
        }
    }

    @Override
    public String toString() {
        if ((ifExists)) {
            return ("Треугольик со сторонами " + a + ", " + b + " и " + c + ";");
        } else {
            return ("Треугольник не может существовать");
        }
    }
}
