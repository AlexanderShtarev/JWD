package com.epam.jwd;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.*;
import com.epam.jwd.model.factory.FigureFactory;
import com.epam.jwd.model.factory.impl.ApplicationContext;

import static com.epam.jwd.model.factory.FigureType.*;
import static com.epam.jwd.model.factory.PointFactory.POINT_FACTORY;

class Main {
    final static private int POINT_LENGTH = 4;
    final static private int LINE_LENGTH = 4;
    final static private int TRIANGLE_LENGTH = 2;
    final static private int SQUARE_LENGTH = 1;
    final static private int MULTI_ANGLE_LENGTH = 2;

    public static void main(String[] args) throws FigureException {
        FigureFactory figureFactory = ApplicationContext.createFigureFactory();

        Point[] points = new Point[POINT_LENGTH];
        points[0] = POINT_FACTORY.createFigure(5, 10);
        points[1] = POINT_FACTORY.createFigure(20, 3);
        points[2] = POINT_FACTORY.createFigure(1, 15);
        points[3] = POINT_FACTORY.createFigure(25, 6);

        int i = 0;
        while (i < POINT_LENGTH) {
            points[i].log();
            i++;
        }

        Figure[] lines = new Line[LINE_LENGTH];
        lines[0] = figureFactory.createFigure(LINE, new Point[]{points[0], points[1]});
        lines[1] = figureFactory.createFigure(LINE, new Point[]{points[0], points[2]});
        lines[2] = figureFactory.createFigure(LINE, new Point[]{points[0], points[3]});
        lines[3] = figureFactory.createFigure(LINE, new Point[]{points[0], points[2]});

        for (Figure el : lines) {
            el.log();
        }

        Figure[] triangles = new Triangle[TRIANGLE_LENGTH];
        triangles[0] = figureFactory.createFigure(TRIANGLE, new Point[]{points[0], points[1], points[2]});
        triangles[1] = figureFactory.createFigure(TRIANGLE, new Point[]{points[1], points[2], points[3]});

        for (Figure el : triangles) {
            el.log();
        }

        Figure[] squares = new Square[SQUARE_LENGTH];
        squares[0] = figureFactory.createFigure(SQUARE, new Point[]{points[0], points[1], points[2], points[3]});

        for (Figure el : squares) {
            el.log();
        }

        Figure[] multiAngleFigures = new MultiAngleFigure[MULTI_ANGLE_LENGTH];
        multiAngleFigures[0] = figureFactory.createFigure(MULTIANGLEFIGURE, new Point[]{points[0], points[1], points[2], points[3]});
        multiAngleFigures[1] = figureFactory.createFigure(MULTIANGLEFIGURE, new Point[]{points[0], points[1], points[2], points[3]});

        for (Figure el : multiAngleFigures) {
            el.log();
            System.out.println(el.executeAreaStrategy());
            System.out.println(el.executePerimeterStrategy());
        }
    }
}
