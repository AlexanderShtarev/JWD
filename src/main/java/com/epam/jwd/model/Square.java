package com.epam.jwd.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Square extends Figura {
    Logger log = LoggerFactory.getLogger(Square.class);

    final int a;
    final int b;
    final int c;
    final int d;

    public Square(final int a, final int b, final int c, final int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    private boolean exists() {
        ifExists = ((a == b) && (c == d)) || ((a == c) && (b == d)) || ((a == d) && (b == c));
        return ifExists;
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
            return ("Квадрат со сторонами " + a + " " + b + " " + c + " " + d);
        } else {
            return ("Квадрат не может существовать");
        }
    }
}
