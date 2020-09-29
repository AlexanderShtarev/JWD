package com.epam.jwd.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Triangle extends Figure implements IExists {
    static Logger log = LoggerFactory.getLogger(Triangle.class);

    private boolean ifFigure;
    private int a;
    private int b;
    private int c;

    public Triangle(final int a, final int b, final int c) {
        ifFigure = ((a != b) && (a != c) && (b != c));
        this.a = Math.abs(a - b);
        this.b = Math.abs(b - c);
        this.c = Math.abs(c - a);
    }

    public void exists() {
        ifExists = ((a < b + c) && (b < a + c) && (c < a + b));
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
