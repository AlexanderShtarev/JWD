package com.epam.jwd.service;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.factory.FigureType;

import java.util.List;

public interface FigureCrud {

    Figure create(FigureType figureType, Point[] figureConstituents) throws FigureException;

    void multiCreate(List<FigureType> figureTypes, Point[] points) throws FigureException;

    void delete(int id);

    void delete(List<Integer> id);

    List<Figure> findAll();

    void update(int id, Figure figure);

    Figure findById(int id);

    List<Figure> findById(List<Integer> id);

    List<Figure> findByCriteria(Criteria criteria);
}