package com.epam.jwd.model;

import com.epam.jwd.model.factory.FigureTypes;
import com.epam.jwd.strategy.OperationStrategy;
import com.epam.jwd.strategy.impl.LineStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Line extends Figure {
    private static Logger log = LoggerFactory.getLogger(Line.class);

    private Point[] figureConstituents;
    private FigureTypes figureTypes;
    private OperationStrategy linePropertiesStrategy;
    private int a;
    private int b;
    private int line;

    public Line(FigureTypes figureType, LineStrategy linePropertiesStrategy, Point[] figureConstituents) {
        super(figureType, linePropertiesStrategy, figureConstituents);
        this.linePropertiesStrategy = linePropertiesStrategy;
        this.figureTypes = figureType;
        this.figureConstituents = figureConstituents;
        this.a = figureConstituents[0].getX();
        this.b = figureConstituents[1].getX();
        line = Math.abs(a - b);
    }

    public boolean exists() {
        isFigure = (a != b);
        isExists = line > 0;
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
        linePropertiesStrategy.doOperationPerimeter(figureConstituents);
        linePropertiesStrategy.doOperationArea(figureConstituents);
        return 2;
    }

    @Override
    public String toString() {
        String print = null;
        if (!isFigure) {
            print = "Объект не является фигурой";
        } else if (!isExists) {
            print = "Линия не может существовать";
        } else {
            print = "" + line;
        }
        return print;
    }

    @Override
    public Point[] getModel() {
        return figureConstituents;
    }
}
