package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.factory.FigureType;
import com.epam.jwd.model.factory.Storage;
import com.epam.jwd.service.FigurePreProcessor;

public class FigurePreProcessorImpl implements FigurePreProcessor {
    private boolean isFigure = true;
    private boolean isExists;
    private Point[] points;
    private FigureType type;

    @Override
    public Figure process(FigureType type, Point[] points) throws FigureException {
        this.points = points;
        this.type = type;
        if (!isFigure()) throw new FigureException();
        if (!exists()) throw new FigureNotExistException();
        final Figure toReturn = Storage.checkIsUnique(type, points);
        return toReturn;
    }

    private boolean isFigure() {
        int i = 0;
        int j = 1;
        while (i < points.length - 1) {
            while (j < points.length) {
                if (points[i].getX() == points[j].getX()) {
                    isFigure = false;
                }
                j++;
            }
            i++;
            j = i + 1;
        }
        return isFigure;
    }

    private boolean exists() {
        switch (type) {
            case LINE:
                isExists = Math.abs(points[0].getX() - points[1].getX()) > 0;
                break;
            case TRIANGLE:
                isExists = ((Math.abs(points[0].getX() - points[1].getX()) <
                        Math.abs(points[1].getX() - points[2].getX()) + Math.abs(points[2].getX() - points[0].getX())))
                        && ((Math.abs(points[1].getX() - points[2].getX()) <
                        Math.abs(points[2].getX() - points[0].getX()) + Math.abs(points[0].getX() - points[1].getX())))
                        && ((Math.abs(points[2].getX() - points[0].getX()) <
                        Math.abs(points[1].getX() - points[2].getX()) + Math.abs(points[0].getX() - points[1].getX())));
                break;
            case SQUARE:
                isExists = ((points[0].getX() - points[1].getX() == points[1].getX() - points[2].getX())
                        && ((points[2].getX() - points[3].getX() == points[3].getX() - points[0].getX())))
                        || ((points[0].getX() - points[1].getX() == points[1].getX() - points[2].getX())
                        && ((points[2].getX() - points[3].getX() == points[3].getX() - points[0].getX())))
                        || ((points[0].getX() - points[1].getX() == points[1].getX() - points[2].getX())
                        && ((points[2].getX() - points[3].getX() == points[3].getX() - points[0].getX())));
                break;
            case MULTIANGLEFIGURE:
                int i = 0;
                int p = 0;
                while (i < points.length - 2) {
                    p += points[i].getX();
                }
                isExists = points[points.length - 1].getX() < p;
                break;
        }
        return isExists;
    }
}
