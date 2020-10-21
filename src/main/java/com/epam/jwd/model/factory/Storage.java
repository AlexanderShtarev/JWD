package com.epam.jwd.model.factory;

import java.util.*;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.impl.Criteria;

public class Storage {
    private static List<Figure> figures = new ArrayList<>();

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

    public static void delete(List<Integer> idOfFiguresToDelete) {
        List<Figure> toRemove = new ArrayList<>();
        idOfFiguresToDelete.forEach(id -> figures.forEach(figure -> {
            if (figure.getID() == id) {
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

    public static List<Figure> findByCriteria(Criteria criteria) {
        List<Figure> figuresToReturn = new ArrayList<>();
        figures.forEach(figure -> {
            if ((criteria.getId() != 0) && (figure.getID() == criteria.getId())
                    && (Objects.equals(criteria.getName(), figure.getName()))
                    && (Objects.equals(criteria.getFigureType(), figure.getType()))) {
                figuresToReturn.add(figure);
            }
        });
        return figuresToReturn;
    }
}
