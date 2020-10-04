package com.epam.jwd.model.factory;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;

import java.util.Arrays;

public class Storage {
    private static Figure[] figures = new Figure[10];
    private static int counter;

    public static Figure checkIsUnique(FigureType figureType, Point[] points) {
        int i = 0;
        if (figures[0] == null) {
            return null;
        } else {
            while ((figures.length - 1 > i) && (figures[i] != null)) {
                if (Arrays.equals(points, figures[i].figureConstituents)) {
                    return figures[i];
                }
                i++;
            }
        }
        return null;
    }

    public static void addToStorage(Figure figure) {
        figures[counter] = figure;
        counter++;
    }
}
