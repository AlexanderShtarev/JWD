package com.epam.jwd.model;

import com.epam.jwd.strategy.OperationStrategy;
import com.epam.jwd.strategy.impl.SquareStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Square extends Figure {
    private static Logger log = LoggerFactory.getLogger(Square.class);

    private int a;
    private int b;
    private int c;
    private int d;
    private Point[] figureConstituents;
    private OperationStrategy squarePropertiesStrategy;

    public Square(String name, SquareStrategy squarePropertiesStrategy, Point[] figureConstituents) {
        super(name, squarePropertiesStrategy, figureConstituents);
        this.figureConstituents = figureConstituents;
        this.name = name;
        this.squarePropertiesStrategy = squarePropertiesStrategy;
        this.a = Math.abs(figureConstituents[0].getX() - figureConstituents[1].getX());
        this.b = Math.abs(figureConstituents[1].getX() - figureConstituents[2].getX());
        this.c = Math.abs(figureConstituents[2].getX() - figureConstituents[3].getX());
        this.d = Math.abs(figureConstituents[3].getX() - figureConstituents[1].getX());
    }

    public boolean exists() {
        isExists = ((a == b) && (c == d)) || ((a == c) && (b == d)) || ((a == d) && (b == c));
        if ((figureConstituents[0].getX() != figureConstituents[1].getX())
                && (figureConstituents[0].getX() != figureConstituents[2].getX())
                && (figureConstituents[0].getX() != figureConstituents[3].getX())
                && (figureConstituents[1].getX() != figureConstituents[2].getX())
                && (figureConstituents[1].getX() != figureConstituents[3].getX())
                && (figureConstituents[2].getX() != figureConstituents[3].getX())) {
            isFigure = true;
        } else isFigure = false;
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
        squarePropertiesStrategy.doOperationPerimeter(figureConstituents);
        squarePropertiesStrategy.doOperationArea(figureConstituents);
        return 2;
    }

    @Override
    public Point[] getModel() {
        return figureConstituents;
    }

    @Override
    public String toString() {
        String print = null;
        if ((isExists) && (isFigure)) {
            print = "Квадрат: " + a + " " + b + " " + c;
        } else if (!isExists) {
            print = "Объект не может существовать";
        } else {
            print = "Объект не является фигурой";
        }
        return print;
    }
}
