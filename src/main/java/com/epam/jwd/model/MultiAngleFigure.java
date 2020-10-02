package com.epam.jwd.model;

import com.epam.jwd.strategy.OperationStrategy;
import com.epam.jwd.strategy.impl.MultiAngleStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiAngleFigure extends Figure {
    private static Logger log = LoggerFactory.getLogger(MultiAngleFigure.class);
    private int a, b, c, d, e, f;
    private int i = 0;
    private int j = 1;
    private Point[] figureConstituents;
    private OperationStrategy multiAnglePropertiesStrategy;

    public MultiAngleFigure(String name, MultiAngleStrategy multiAnglePropertiesStrategy, Point[] figureConstituents) {
        super(name, multiAnglePropertiesStrategy, figureConstituents);
        this.multiAnglePropertiesStrategy = multiAnglePropertiesStrategy;
        this.figureConstituents = figureConstituents;
        this.a = figureConstituents[0].getX();
        this.b = figureConstituents[1].getX();
        this.c = figureConstituents[2].getX();
        this.d = figureConstituents[3].getX();
        if (figureConstituents.length == 5) {
            this.e = figureConstituents[4].getX();
        }
        if (figureConstituents.length == 6) {
            this.f = figureConstituents[5].getX();
        }
    }

    public boolean exists() {
        isExists = ((a == b) && (c == d)) || ((a == c) && (b == d)) || ((a == d) && (b == c));
        while (i < figureConstituents.length - 1) {
            while (j < figureConstituents.length) {
                if (figureConstituents[i].getX() == figureConstituents[j].getX()) {
                    isFigure = false;
                }
                j++;
            }
            i++;
            j = i + 1;
        }
        return (isExists) && (isFigure);
    }

    public void log() {
        exists();
        if ((isExists) && (isFigure)) {
            log.info(toString());
        } else {
            log.error(toString());
        }
    }

    public double executeStrategy(Point[] figureConstituents) {
        multiAnglePropertiesStrategy.doOperationPerimeter(figureConstituents);
        multiAnglePropertiesStrategy.doOperationArea(figureConstituents);
        return 2;
    }

    @Override
    public Point[] getModel() {
        return figureConstituents;
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