package com.epam.jwd.service.impl;

import com.epam.jwd.model.factory.FigureType;

public class Criteria {

    private int id;
    private String name;
    private FigureType figureType;

    private Criteria() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public FigureType getFigureType() {
        return figureType;
    }

    public static Builder newBuilder() {
        return new Criteria().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setId(int userId) {
            Criteria.this.id = userId;
            return this;
        }

        public Builder setName(String name) {
            Criteria.this.name = name;
            return this;
        }

        public Builder setFigureType(FigureType figureType) {
            Criteria.this.figureType = figureType;
            return this;
        }

        public Criteria build() {
            return Criteria.this;
        }

    }

}