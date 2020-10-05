package com.epam.jwd;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.*;

import static com.epam.jwd.model.factory.FigureFactory.*;
import static com.epam.jwd.model.factory.FigureType.*;
import static com.epam.jwd.model.factory.PointFactory.POINT_FACTORY;

class Main {
    final static private int POINTLENGTH = 5;
    final static private int LINELENGTH = 4;
    final static private int TRIANGLELENGTH = 2;
    final static private int SQUARELENGTH = 1;
    final static private int MULTIANGLEFIGURELENGTH = 2;

    public static void main(String[] args) throws FigureException {
        Point[] points = new Point[POINTLENGTH];
        points[0] = POINT_FACTORY.createFigure(5);
        points[1] = POINT_FACTORY.createFigure(7);
        points[2] = POINT_FACTORY.createFigure(9);
        points[3] = POINT_FACTORY.createFigure(6);
        points[4] = POINT_FACTORY.createFigure(10);

        int i = 0;
        while (i < POINTLENGTH) {
            points[i].log();
            i++;
        }

        Figure[] line = new Line[LINELENGTH];
        line[0] = FIGURE_FACTORY.createFigure(LINE, new Point[]{points[0], points[1]});
        line[1] = FIGURE_FACTORY.createFigure(LINE, new Point[]{points[0], points[2]});
        line[2] = FIGURE_FACTORY.createFigure(LINE, new Point[]{points[0], points[3]});
        line[3] = FIGURE_FACTORY.createFigure(LINE, new Point[]{points[0], points[1]});

        for (Figure el : line) {
            el.log();
        }

        Figure[] triangle = new Triangle[TRIANGLELENGTH];
        triangle[0] = FIGURE_FACTORY.createFigure(TRIANGLE, new Point[]{points[0], points[1], points[2]});
        triangle[1] = FIGURE_FACTORY.createFigure(TRIANGLE, new Point[]{points[0], points[1], points[3]});

        for (Figure el : triangle) {
            el.log();
        }

        Figure[] square = new Square[SQUARELENGTH];
        square[0] = FIGURE_FACTORY.createFigure(SQUARE, new Point[]{points[0], points[1], points[2], points[3]});

        for (Figure el : square) {
            el.log();
        }
        Figure[] multiAngleFigure = new MultiAngleFigure[MULTIANGLEFIGURELENGTH];
        multiAngleFigure[0] = FIGURE_FACTORY.createFigure(MULTIANGLEFIGURE, new Point[]{points[0], points[1], points[2],
                points[4], points[3]});
        multiAngleFigure[1] = FIGURE_FACTORY.createFigure(MULTIANGLEFIGURE, new Point[]{points[0], points[1], points[2],
                points[4], points[3]});

        for (Figure el : multiAngleFigure) {
            el.log();
        }
    }
}