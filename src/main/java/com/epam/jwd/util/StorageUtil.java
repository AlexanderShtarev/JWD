package com.epam.jwd.util;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;

import java.util.Arrays;

public class StorageUtil {

    public static Object resizeArray(Object oldArray, int newSize) {
        int oldSize = java.lang.reflect.Array.getLength(oldArray);
        Class elementType = oldArray.getClass().getComponentType();
        Object newArray = java.lang.reflect.Array.newInstance(elementType, newSize);
        int preserveLength = Math.min(oldSize, newSize);
        if (preserveLength > 0)
            System.arraycopy(oldArray, 0, newArray, 0, preserveLength);
        return newArray;
    }

    public static Figure ifExistsInTheStorage(Figure[] figures, Point[] points) {
        int i = 0;
        while ((figures.length - 1 > i) && (figures[i] != null)) {
            if (Arrays.equals(points, figures[i].figureConstituents)) {
                return figures[i];
            }
            i++;
        }
        return null;
    }
}
