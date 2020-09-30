package com.epam.jwd.model;

import com.epam.jwd.model.factory.FigureTypes;
import com.epam.jwd.strategy.OperationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Line extends Figure {
    private static Logger log = LoggerFactory.getLogger(Line.class);

    private FigureTypes figureTypes;
    private OperationStrategy figurePropertiesStrategy;
    private Point[] figureConsistence;
    private int a;
    private int b;
    private int line;

    public Line(FigureTypes figureType, OperationStrategy figurePropertiesStrategy, Point[] figureConsistence) {
        super(figureType, figurePropertiesStrategy, figureConsistence);
        this.figureTypes = figureType;
        this.figurePropertiesStrategy = figurePropertiesStrategy;
        this. figureConsistence =figureConsistence;
        this.a = figureConsistence[0].getX();
        this.b = figureConsistence[1].getX();
        line = Math.abs(a-b);
    }

    private void exists() {
        isFigure = (a != b);
        isExists = line > 0;
    }

    public void log() {
        exists();
        if ((isExists) && (isFigure)) {
            log.info(toString());
        } else {
            log.error(toString());
        }
    }

    public double executeStrategy(OperationStrategy figurePropertiesStrategy, Point[] figureConsistence) {
        return figurePropertiesStrategy.doOperation(figureConsistence);
    }

    @Override
    public String toString() {
        String print = null;
        if (!isExists) {
            print = "Линия не может существовать";
        } else if (!isFigure){
            print = "Объект не является фигурой";
        } else {
            print = "" + line;
        } return print;
    }
}
