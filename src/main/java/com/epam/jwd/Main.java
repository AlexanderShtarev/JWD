package com.epam.jwd;

import com.epam.jwd.decorator.PostProcessingFactory;
import com.epam.jwd.decorator.PreProcessingFactory;
import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.factory.FigureFactory;
import com.epam.jwd.model.factory.Storage;
import com.epam.jwd.model.factory.impl.ApplicationContext;
import com.epam.jwd.service.Criteria;
import com.epam.jwd.service.FigureCrud;
import com.epam.jwd.service.impl.CriteriaImpl;
import com.epam.jwd.service.impl.FigureCrudImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static com.epam.jwd.model.factory.FigureType.LINE;
import static com.epam.jwd.service.impl.FigurePostProcessorImpl.FIGURE_POST_PROCESSOR_IMPL;
import static com.epam.jwd.service.impl.FigurePreProcessorImpl.FIGURE_PRE_PROCESSOR_IMPL;

class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws FigureException {
        PostProcessingFactory.addPostProcesses(FIGURE_POST_PROCESSOR_IMPL);
        PreProcessingFactory.addPreProcesses(FIGURE_PRE_PROCESSOR_IMPL);

        FigureFactory figureFactory = ApplicationContext.createFigureFactory();

        Storage storage = new Storage();

        FigureCrud figureCrud = new FigureCrudImpl(figureFactory);

        List<Point> points = new ArrayList<>();
        Point point1 = new Point(1, 5);
        Point point2 = new Point(2, 4);
        Point point3 = new Point(3, 3);
        Point point4 = new Point(4, 2);

        List<Figure> lines = new ArrayList<>();
        Figure line1 = figureCrud.create(LINE, new Point[]{point1, point2});
        Figure line2 = figureCrud.create(LINE, new Point[]{point1, point3});
        Figure line3 = figureCrud.create(LINE, new Point[]{point2, point3});
        lines.add(line1);
        lines.add(line2);
        lines.add(line3);
        List<Integer> idList = new ArrayList<>();
        idList.add(line1.getID());
        idList.add(line2.getID());


        Criteria criteria = new CriteriaImpl().setFigureType(LINE).setId(2);
        List<Figure> figuresByCriteria = (figureCrud.findByCriteria(criteria));
        System.out.println(figuresByCriteria);
        figureCrud.delete(idList);

    }
}
