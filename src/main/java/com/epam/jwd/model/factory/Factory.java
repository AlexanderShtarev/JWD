package com.epam.jwd.model.factory;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.strategy.OperationStrategy;

public interface Factory {
    Figure createFigure(FigureTypes type, OperationStrategy figurePropertiesStrategy, Point[] figureConsistence);
}
