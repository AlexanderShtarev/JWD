package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.factory.FigureFactory;
import com.epam.jwd.model.factory.FigureType;
import com.epam.jwd.model.factory.Storage;
import com.epam.jwd.service.FigureCrud;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class FigureCrudImpl implements FigureCrud {
    private final FigureFactory figureFactory;
    private static final Logger LOGGER = LoggerFactory.getLogger(FigureCrud.class);

    public FigureCrudImpl(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    @Override
    public Figure create(FigureType figureType, Point[] figureConstituents) throws FigureException {
        return figureFactory.createFigure(figureType, figureConstituents);
    }

    @Override
    public void multiCreate(List<MultiCreateFigureContext> multiCreateList) {
        multiCreateList.forEach(figure -> {
            try {
                figureFactory.createFigure(figure.getType(), figure.getPoints());
            } catch (FigureNotExistException e) {
                LOGGER.error("Figure can't exist");
            } catch (FigureException e) {
                LOGGER.error("Object can't be a figure");
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
        try {
            Storage.update(id, figure);
        } catch (IndexOutOfBoundsException e) {
            LOGGER.error("Figure with id " + id + " does not exist");
        }
    }

    @Override
    public Optional<Figure> findById(int id) {
        return Storage.findById(id);
    }

    @Override
    public List<Figure> findById(List<Integer> id) {
        return Storage.findById(id);
    }

    @Override
    public List<Figure> findByCriteria(Criteria criteria) {
        return Storage.findByCriteria(criteria);
    }
}
