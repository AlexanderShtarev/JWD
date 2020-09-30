package com.epam.jwd;

import com.epam.jwd.model.Point;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Line;
import com.epam.jwd.model.Square;
import com.epam.jwd.model.Triangle;
import com.epam.jwd.model.MultiAngleFigure;
import com.epam.jwd.model.factory.FigureFactory;
import com.epam.jwd.model.factory.PointFactory;
import com.epam.jwd.strategy.impl.OperationPerimeter;
import com.epam.jwd.strategy.impl.OperationTriangleArea;

import static com.epam.jwd.model.factory.FigureTypes.*;
import static com.epam.jwd.strategy.impl.OperationMultiAngleFigureArea.OPERATION_MULTIANGLEFIGUREAREA_INSTANCE;
import static com.epam.jwd.strategy.impl.OperationPerimeter.OPERATION_PERIMETER_INSTANCE;
import static com.epam.jwd.strategy.impl.OperationSquareArea.OPERATION_SQUAREAREA_INSTANCE;
import static com.epam.jwd.strategy.impl.OperationTriangleArea.OPERATION_TRIANGLEAREA_INSTANCE;

class Main {

    final static private int POINTLENGTH = 5;
    final static private int LINELENGTH = 4;
    final static private int TRIANGLELENGTH = 2;
    final static private int SQUARELENGTH = 1;
    final static private int MULTIANGLEFIGURELENGTH = 2;

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
        Point[] line1points = new Point[]{points[0], points[1]};
        Point[] line2points = new Point[]{points[0], points[2]};
        Point[] line3points = new Point[]{points[0], points[3]};
        Point[] line4points = new Point[]{points[0], points[4]};

        Point[] triangle1points = new Point[]{points[0], points[1], points[2]};
        Point[] triangle2points = new Point[]{points[0], points[2], points[4]};

        Point[] square1points = new Point[]{points[0], points[3], points[2], points[4]};

        Point[] multiAgnleFigure1points = new Point[]{points[0], points[1], points[1], points[2], points[4]};
        Point[] multiAngleFigure2points = new Point[]{points[0], points[2], points[1], points[4]};

        Figure[] line = new Line[LINELENGTH];
        line[0] = figureFactory.createFigure(LINE, OPERATION_PERIMETER_INSTANCE, line1points);
        line[1] = figureFactory.createFigure(LINE, OPERATION_PERIMETER_INSTANCE, line2points);
        line[2] = figureFactory.createFigure(LINE, OPERATION_PERIMETER_INSTANCE, line3points);
        line[3] = figureFactory.createFigure(LINE, OPERATION_PERIMETER_INSTANCE, line4points);

        for (Figure el : line) {
            el.log();
        }

        Figure[] triangle = new Triangle[TRIANGLELENGTH];
        triangle[0] = figureFactory.createFigure(TRIANGLE, OPERATION_TRIANGLEAREA_INSTANCE, triangle1points);
        triangle[1] = figureFactory.createFigure(TRIANGLE, OPERATION_PERIMETER_INSTANCE, triangle2points);

        for (Figure el : triangle) {
            el.log();
        }

        Figure[] square = new Square[SQUARELENGTH];
        square[0] = figureFactory.createFigure(SQUARE, OPERATION_SQUAREAREA_INSTANCE, square1points);

        for (Figure el : square) {
            el.log();
        }
        Figure[] multiAngleFigure = new MultiAngleFigure[MULTIANGLEFIGURELENGTH];
        multiAngleFigure[0] = figureFactory.createFigure(MULTIANGLEFIGURE, OPERATION_PERIMETER_INSTANCE, multiAgnleFigure1points);
        multiAngleFigure[1] = figureFactory.createFigure(MULTIANGLEFIGURE, OPERATION_MULTIANGLEFIGUREAREA_INSTANCE, multiAngleFigure2points);

        for (Figure el : multiAngleFigure) {
            el.log();
        }
    }
}
