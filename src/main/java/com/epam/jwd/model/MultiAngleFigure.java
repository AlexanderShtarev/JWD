package com.epam.jwd.model;

import com.epam.jwd.model.factory.FigureTypes;
import com.epam.jwd.strategy.OperationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiAngleFigure extends Figure {
    private static Logger log = LoggerFactory.getLogger(MultiAngleFigure.class);
    private int a, b, c, d, e, f;
    private Point[] figureConsistence;
    private int i = 0;
    private int k = 1;

    public MultiAngleFigure(FigureTypes figureType, OperationStrategy figurePropertiesStrategy, Point[] figureConsistence) {
        super(figureType, figurePropertiesStrategy, figureConsistence);
        this.figureConsistence = figureConsistence;
        this.a = figureConsistence[0].getX();
        this.b = figureConsistence[1].getX();
        this.c = figureConsistence[2].getX();
        this.d = figureConsistence[3].getX();
        if (figureConsistence.length == 5) {
            this.e = figureConsistence[4].getX();
        }
        if (figureConsistence.length == 6) {
            this.f = figureConsistence[5].getX();
        }
    }

    private void exists() {
        isExists = ((a == b) && (c == d)) || ((a == c) && (b == d)) || ((a == d) && (b == c));
        while (i < figureConsistence.length - 1) {
            while (k < figureConsistence.length) {
                if (figureConsistence[i].getX() == figureConsistence[k].getX()) {
                    isFigure = false;
                }
                k++;
            }
            i++;
            k = i + 1;
        }
    }

    public void log() {
        exists();
        if ((isExists) && (isFigure)) {
            log.info(toString());
        } else {
            log.error(toString());
        }
    }

    @Override
    public String toString() {
        String print = null;
        if (!isFigure) {
            print = "Объект не является фигурой";
        } else if (!isExists) {
            print = "Многоугольник не может существовать";
        } else {
            print = a + " " + b + " " + c + " " + " " + d + " " + e + " " + f;
        }
        return print;
    }
}