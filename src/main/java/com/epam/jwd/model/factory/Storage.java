package com.epam.jwd.model.factory;

import java.util.*;
import java.util.stream.Collectors;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.impl.Criteria;

public class Storage {
    private static List<Figure> storageFigures = new ArrayList<>();

    private Storage() {
    }

    public static void addToStorage(Figure figure) {
        storageFigures.add(figure);
    }

    public static void update(int id, Figure figure) {
        storageFigures.set(storageFigures.indexOf(storageFigures.get(id - 1)), figure);
    }

    public static void delete(long id) {
        storageFigures.removeIf(figure -> figure.getID() == id);
    }

    public static void delete(List<Integer> figureId) {
        List<Figure> toDelete =
                storageFigures.stream()
                        .filter(figure -> figureId.stream().anyMatch(id -> id == figure.getID()))
                        .collect(Collectors.toList());
        storageFigures.removeAll(toDelete);
    }

    public static List<Figure> findAll() {
        return storageFigures;
    }

    public static Optional<Figure> findById(int id) {
        return storageFigures.stream().filter((figure) -> figure.getID() == id).findAny();
    }

    public static List<Figure> findById(List<Integer> idList) {
        return storageFigures.stream()
                .filter(figure -> idList.stream().anyMatch(id -> id == figure.getID()))
                .collect(Collectors.toList());
    }

    public static List<Figure> findByCriteria(Criteria criteria) {
        return storageFigures.stream()
                .filter(figure -> (criteria.getId() != 0) && (criteria.getId() == figure.getID()))
                .filter(figure -> Objects.equals(criteria.getFigureType(), figure.getType()))
                .filter(figure -> Objects.equals(criteria.getName(), figure.getNAME()))
                .collect(Collectors.toList());
    }

    public static Optional<Figure> checkIfUnique(Point[] points) {
        return storageFigures.stream()
                .filter(figure -> Arrays.equals(figure.getModel(), points))
                .findFirst();
    }
}
