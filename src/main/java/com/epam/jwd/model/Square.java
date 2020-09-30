package com.epam.jwd.model;

import com.epam.jwd.model.factory.FigureTypes;
import com.epam.jwd.strategy.OperationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Square extends Figure {
    private static Logger log = LoggerFactory.getLogger(Square.class);

    private int a;
    private int b;
    private int c;
    private int d;
    private Point[] figureConsistence;

    public Square(FigureTypes figureType, OperationStrategy figurePropertiesStrategy, Point[] figureConsistence) {
        super(figureType, figurePropertiesStrategy, figureConsistence);
        this.figureConsistence = figureConsistence;
        this.a = Math.abs(figureConsistence[0].getX() - figureConsistence[1].getX());
        this.b = Math.abs(figureConsistence[1].getX() - figureConsistence[2].getX());
        this.c = Math.abs(figureConsistence[2].getX() - figureConsistence[3].getX());
        this.d = Math.abs(figureConsistence[3].getX() - figureConsistence[1].getX());
    }

        private void exists() {
        isExists = ((a == b) && (c == d)) || ((a == c) && (b == d)) || ((a == d) && (b == c));
        isFigure = figureConsistence[0].getX() != figureConsistence[1].getX()
                && figureConsistence[0].getX() != figureConsistence[2].getX()
                && figureConsistence[0].getX() != figureConsistence[3].getX()
                && figureConsistence[1].getX() != figureConsistence[2].getX()
                && figureConsistence[1].getX() != figureConsistence[3].getX()
                && figureConsistence[2].getX() != figureConsistence[3].getX();
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
            print = "Квадрат: " + a + " " + b + " " + c;
        } else if (!isExists) {
            print = "Квадрат не может существовать";
        } else {
            print = "Квадрат не является фигурой";
        }
        return print;
    }
}
