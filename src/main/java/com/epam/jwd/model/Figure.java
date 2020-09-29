package com.epam.jwd.model;

import com.epam.jwd.strategy.OperationStrategy;

public abstract class Figure {
    static int id;
    private Enum figureType;
    boolean ifExists;
    OperationStrategy figurePropertiesStrategy;

    public abstract void log();

}
