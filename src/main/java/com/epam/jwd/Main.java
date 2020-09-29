package com.epam.jwd;

import com.epam.jwd.model.Point;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Line;
import com.epam.jwd.model.Square;
import com.epam.jwd.model.Triangle;
import com.epam.jwd.model.MultiAngleFigure;
import com.epam.jwd.model.factory.FigureFactory;
import com.epam.jwd.model.factory.FigureTypes;
import com.epam.jwd.model.factory.PointFactory;

class Main {

    final static private int POINTLENGTH = 5;
    final static private int LINELENGTH = 4;
    final static private int TRIANGLELENGTH = 2;
    final static private int SQUARELENGTH = 1;
    final static private int MULTIANGLEFIGURELEGTH = 2;

    public static void main(String[] args) {
        PointFactory factory = new PointFactory();
        FigureFactory figureFactory = new FigureFactory();

        Point[] points = new Point[POINTLENGTH];
        points[0] = factory.createFigure(3);
        points[1] = factory.createFigure(5);
        points[2] = factory.createFigure(9);
        points[3] = factory.createFigure(3);
        points[4] = factory.createFigure(7);

        int i = 0;
        while (i < POINTLENGTH) {
            points[i].log();
            i++;
        }

        Figure[] lines = new Line[LINELENGTH];
        lines[0] = figureFactory.createFigure(FigureTypes.LINE, new int[]{points[0].getX(), points[0].getX()});
        lines[1] = figureFactory.createFigure(FigureTypes.LINE, new int[]{points[0].getX(), points[1].getX()});
        lines[2] = figureFactory.createFigure(FigureTypes.LINE, new int[]{points[2].getX(), points[3].getX()});
        lines[3] = figureFactory.createFigure(FigureTypes.LINE, new int[]{points[1].getX(), points[2].getX()});

        for (Figure line : lines) {
            line.log();
        }

        Figure[] triangles = new Triangle[TRIANGLELENGTH];
        triangles[0] = figureFactory.createFigure(FigureTypes.TRIANGLE, new int[]{points[0].getX(), points[1].getX(), points[2].getX()});
        triangles[1] = figureFactory.createFigure(FigureTypes.TRIANGLE, new int[]{points[1].getX(), points[2].getX(), points[3].getX()});

        for (Figure triangle : triangles) {
            triangle.log();
        }

        Figure[] squares = new Square[SQUARELENGTH];
        squares[0] = figureFactory.createFigure(FigureTypes.SQUARE, new int[]{points[0].getX(), points[1].getX(), points[2].getX(), points[3].getX()});

        for (Figure square : squares) {
            square.log();
        }

        Figure[] multiAngleFigures = new MultiAngleFigure[MULTIANGLEFIGURELEGTH];
        multiAngleFigures[0] = figureFactory.createFigure(FigureTypes.MULTIANGLEFIGURE, new int[]{points[0].getX(), points[1].getX(), points[2].getX(), points[3].getX(), points[4].getX()});
        multiAngleFigures[1] = figureFactory.createFigure(FigureTypes.MULTIANGLEFIGURE, new int[]{points[0].getX(), points[1].getX(), points[2].getX(), points[3].getX()});

        for (Figure multiAngleFigure : multiAngleFigures) {
            multiAngleFigure.log();
        }
    }
}
