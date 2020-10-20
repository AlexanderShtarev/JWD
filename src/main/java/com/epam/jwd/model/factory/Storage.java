package com.epam.jwd.model.factory;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Storage {
    private static List<Figure> figures = new ArrayList<>();
    private static Logger log = LoggerFactory.getLogger(Storage.class);

    public static Optional<Figure> checkIfUnique(Point[] points) {
        return figures.stream()
                .filter(figure -> Arrays.equals(figure.getModel(), points))
                .findFirst();
    }

    public static List<Figure> findAll() {
        return figures;
    }

    public static void addToStorage(Figure figure) {
        figures.add(figure);
    }

    public static void delete(long id) {
        figures.removeIf(figure -> figure.getID() == id);
    }

    public static void delete(List<Integer> id) {
        List<Figure> toRemove = new ArrayList<>();
        id.forEach(idToDelete -> figures.forEach(figure -> {
            if (figure.getID() == idToDelete) {
                toRemove.add(figure);
            }
        }));
        figures.removeAll(toRemove);
    }

    public static void update(int id, Figure figure) {
        figures.set(figures.indexOf(figures.get(id - 1)), figure);
    }

    public static Figure findById(int id) {
        return figures.stream().filter((figure) -> figure.getID() == id).findAny().get();
    }

    public static List<Figure> findById(List<Integer> idList) {
        List<Figure> figuresToReturn = new ArrayList<>();
        idList.forEach(integer -> figures.forEach(figure -> {
            if (figure.getID() == integer) {
                figuresToReturn.add(figure);
            }
        }));
        return figuresToReturn;
    }
}
