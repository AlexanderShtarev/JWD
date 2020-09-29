package com.epam.jwd.model;

import com.epam.jwd.strategy.OperationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Square extends Figure implements IExists {
    Logger log = LoggerFactory.getLogger(Square.class);

    private boolean ifFigure;
    final int a;
    final int b;
    final int c;
    final int d;

    public Square(int a, int b, int c, int d) {
        ifFigure = ((a != b) && (a != c) && (a != d) && (b != c) && (b != d) && (c != d));
        this.a = Math.abs(a - b);
        this.b = Math.abs(b - c);
        this.c = Math.abs(c - d);
        this.d = Math.abs(d - a);
    }

    public void exists() {
        ifExists = ((a == b) && (c == d)) || ((a == c) && (b == d)) || ((a == d) && (b == c));
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
        if ((ifExists) && (ifFigure)) {
            return ("Квадрат со сторонами " + a + " " + b + " " + c + " " + d);
        } else {
            return ("Квадрат не может существовать");
        }
    }
}
