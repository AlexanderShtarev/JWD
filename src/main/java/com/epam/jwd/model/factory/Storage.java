package com.epam.jwd.model.factory;

import java.util.*;
import java.util.stream.Collectors;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.impl.Criteria;

public class Storage {
    private static final List<Figure> STORAGE_FIGURES = new ArrayList<>();

    private Storage() {
    }

    public static void addToStorage(Figure figure) {
        STORAGE_FIGURES.add(figure);
    }

    public static void update(int id, Figure figure) {
        STORAGE_FIGURES.set(STORAGE_FIGURES.indexOf(STORAGE_FIGURES.get(id - 1)), figure);
    }

    public static void delete(long id) {
        STORAGE_FIGURES.removeIf(figure -> figure.getID() == id);
    }

    public static void delete(List<Integer> figureId) {
        List<Figure> toDelete =
                STORAGE_FIGURES.stream()
                        .filter(figure -> figureId.stream().anyMatch(id -> id == figure.getID()))
                        .collect(Collectors.toList());
        STORAGE_FIGURES.removeAll(toDelete);
    }

    public static List<Figure> findAll() {
        return STORAGE_FIGURES;
    }

    public static Optional<Figure> findById(int id) {
        return STORAGE_FIGURES.stream().filter((figure) -> figure.getID() == id).findAny();
    }

    public static List<Figure> findById(List<Integer> idList) {
        return STORAGE_FIGURES.stream()
                .filter(figure -> idList.stream().anyMatch(id -> id == figure.getID()))
                .collect(Collectors.toList());
    }

    public static List<Figure> findByCriteria(Criteria criteria) {
        return STORAGE_FIGURES.stream()
                .filter(figure -> (criteria.getId() != 0) && (criteria.getId() == figure.getID()))
                .filter(figure -> Objects.equals(criteria.getFigureType(), figure.getType()))
                .filter(figure -> Objects.equals(criteria.getName(), figure.getName()))
                .collect(Collectors.toList());
    }

    public static Optional<Figure> checkIfUnique(Point[] points) {
        return STORAGE_FIGURES.stream()
                .filter(figure -> Arrays.equals(figure.getModel(), points))
                .findFirst();
    }
}
