package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.factory.FigureFactory;
import com.epam.jwd.model.factory.FigureType;
import com.epam.jwd.model.factory.Storage;
import com.epam.jwd.service.FigureCrud;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class FigureCrudImpl implements FigureCrud {
    private FigureFactory figureFactory;
    private static Logger log = LoggerFactory.getLogger(FigureCrud.class);
    public FigureCrudImpl(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    @Override
    public Figure create(FigureType figureType, Point[] figureConstituents) throws FigureException {
        return figureFactory.createFigure(figureType, figureConstituents);
    }

    @Override
    public void multiCreate(List<MultiCreateFigureContext> multuCreateList) throws FigureException {
        multuCreateList.forEach(figure -> {
            try {
                figureFactory.createFigure(figure.getType(), figure.getPoints());
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
        log.info(Storage.findAll() + "");
        return Storage.findAll();
    }

    @Override
    public void update(int id, Figure figure) {
        Storage.update(id, figure);
    }

    @Override
    public Figure findById(int id) {
        log.info(Storage.findById(id) + "");
        return Storage.findById(id);
    }

    @Override
    public List<Figure> findById(List<Integer> id) {
        log.info(Storage.findById(id) + "");
        return Storage.findById(id);
    }

    @Override
    public List<Figure> findByCriteria(Criteria criteria) {
        log.info(Storage.findByCriteria(criteria) + "");
        return Storage.findByCriteria(criteria);
    }
}
