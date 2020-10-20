package com.epam.jwd.service;

import com.epam.jwd.model.factory.FigureType;

public interface Criteria {
    Criteria setName(String name);

    Criteria setId(int id);

    Criteria setFigureType(FigureType figureType);

    Criteria build();

    String getName();
}
