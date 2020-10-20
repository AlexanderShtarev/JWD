package com.epam.jwd.service.impl;

import com.epam.jwd.model.Point;
import com.epam.jwd.model.factory.FigureType;
import com.epam.jwd.service.Criteria;

public class CriteriaImpl implements Criteria {
    private String name;
    private int id;
    Point[] points;
    private FigureType figureType;
    static CriteriaImpl criteria = new CriteriaImpl();

    @Override
    public Criteria setName(String name) {
        criteria.name = name;
        return this;
    }

    @Override
    public Criteria setId(int id) {
        criteria.id = id;
        return this;
    }

    @Override
    public Criteria setFigureType(FigureType figureType) {
        criteria.figureType = figureType;
        return this;
    }

    @Override
    public Criteria build() {
        return criteria;
    }

    @Override
    public String getName() {
        return name;
    }
}
