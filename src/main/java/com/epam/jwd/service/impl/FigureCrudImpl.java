package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.factory.FigureFactory;
import com.epam.jwd.model.factory.FigureType;
import com.epam.jwd.model.factory.Storage;
import com.epam.jwd.service.FigureCrud;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FigureCrudImpl implements FigureCrud {
    private FigureFactory figureFactory;

    public FigureCrudImpl(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    @Override
    public Figure create(FigureType figureType, Point[] figureConstituents) throws FigureException {
        return figureFactory.createFigure(figureType, figureConstituents);
    }

    @Override
    public void multiCreate(List<FigureType> figureTypes, Point[] points) throws FigureException {
        figureTypes.forEach(figureType -> {
            try {
                figureFactory.createFigure(figureType, points);
            } catch (FigureException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void delete(int id) {
        Storage.delete(id);
    }

    @Override
    public void delete(List<Integer> id) {
        Storage.delete(id);
    }

    @Override
    public List<Figure> findAll() {
        return Storage.findAll();
    }

    @Override
    public void update(int id, Figure figure) {
        Storage.update(id, figure);
    }

    @Override
    public Figure findById(int id) {
        return Storage.findById(id);
    }

    @Override
    public List<Figure> findById(List<Integer> id) {
        return Storage.findById(id);
    }

    @Override
    public List<Figure> findByCriteria(List<Figure> figures, Predicate<Figure> predicate) {
        return Storage.findByCriteria(figures, predicate);
    }
}
