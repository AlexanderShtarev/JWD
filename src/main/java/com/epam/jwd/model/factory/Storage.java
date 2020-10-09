package com.epam.jwd.model.factory;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;

import static com.epam.jwd.util.StorageUtil.*;

public class Storage {
    private static int counter;
    private static Figure[] figures = new Figure[10];

    public static Figure checkIsUnique(Point[] points) {
        if (figures[0] == null) {
            return null;
        } else {
            return ifExistsInTheStorage(figures, points);
        }
    }

    public static void addToStorage(Figure figure) {
        if (figures[figures.length - 1] != null) {
            figures = (Figure[]) resizeArray(figures, figures.length + 10);
        }
        figures[counter] = figure;
        counter++;
    }
}
