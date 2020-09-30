package com.epam.jwd.model;

import com.epam.jwd.model.factory.FigureTypes;
import com.epam.jwd.strategy.OperationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Triangle extends Figure {
    private static Logger log = LoggerFactory.getLogger(Triangle.class);

    private int a;
    private int b;
    private int c;

    public Triangle(FigureTypes figureType, OperationStrategy figurePropertiesStrategy, Point[] figureConsistence) {
        super(figureType, figurePropertiesStrategy, figureConsistence);
        this.a = Math.abs(figureConsistence[0].getX() - figureConsistence[1].getX());
        this.b = Math.abs(figureConsistence[1].getX() - figureConsistence[2].getX());
        this.c = Math.abs(figureConsistence[2].getX() - figureConsistence[1].getX());
        isFigure = ((figureConsistence[0].getX() != figureConsistence[1].getX())
                && (figureConsistence[0].getX() != figureConsistence[2].getX())
                && (figureConsistence[1].getX() != figureConsistence[2].getX()));
    }

    private void exists() {
        isExists = ((a < b + c) && (b < a + c) && (c < a + b));
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
        if ((isExists) && (isFigure)) {
            print = "Треугольник: " + a + " " + b + " " + c;
        } else if (!isExists) {
            print = "Треугольник не может существовать";
        } else {
            print = "Объект не является фигурой";
        }
        return print;
    }
}
