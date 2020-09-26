package com.epam.jwd;

import com.epam.jwd.model.*;

class Main {

    final static private int pointLength = 4;
    final static private int lineLength = 4;
    final static private int triangleLength = 2;
    final static private int squareLength = 1;

    public static void main(String[] args) {

        Point[] points = new Point[pointLength];
        points[0] = new Point(4);
        points[1] = new Point(8);
        points[2] = new Point(10);
        points[3] = new Point(7);

        int i = 0;
        while (i < pointLength) {
            points[i].log();
            i++;
        }

        Line[] lines = new Line[lineLength];
        lines[0] = new Line(points[0].getPoint(), points[1].getPoint());
        lines[1] = new Line(points[0].getPoint(), points[2].getPoint());
        lines[2] = new Line(points[0].getPoint(), points[3].getPoint());
        lines[3] = new Line(points[1].getPoint(), points[2].getPoint());

        for (Line line : lines) {
            line.log();
        }

        Triangle[] triangles = new Triangle[triangleLength];
        triangles[0] = new Triangle(lines[0].getLine(), lines[1].getLine(), lines[2].getLine());
        triangles[1] = new Triangle(lines[3].getLine(), lines[0].getLine(), lines[1].getLine());

        for (Triangle triangle : triangles) {
            triangle.log();
        }

        Square[] squares = new Square[squareLength];
        squares[0] = new Square(lines[0].getLine(), lines[1].getLine(), lines[2].getLine(), lines[3].getLine());

        for (Square square : squares) {
            square.log();
        }
    }
}
