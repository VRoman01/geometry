package com.epam.geometry.creator;

import com.epam.geometry.creator.util.FormatValidator;
import com.epam.geometry.creator.util.LogicValidator;
import com.epam.geometry.creator.util.Parser;
import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Tetrahedron;
import java.util.Optional;

public class TetrahedronCreator {


    private final FormatValidator formatValidator;
    private final Parser parser;
    private final LogicValidator logicValidator;

    public TetrahedronCreator(FormatValidator formatValidator, Parser parser, LogicValidator logicValidator) {
        this.formatValidator = formatValidator;
        this.parser = parser;
        this.logicValidator = logicValidator;
    }

    public Optional<Tetrahedron> create(String parameters){

        final double[] parsedParameters;

        if (formatValidator.isValid(parameters)){
            parsedParameters = parser.parseDoubles(parameters);
        } else {
            return Optional.empty();
        }

        if (logicValidator.isTetrahedron(parsedParameters)){
            Tetrahedron tetrahedron = create(parsedParameters);
            return Optional.of(tetrahedron);
        }else {
            return Optional.empty();
        }
    }

    private Tetrahedron create(double[] parsedParameters){
        Point first = new Point(parsedParameters[0],parsedParameters[1],parsedParameters[2]);
        Point second = new Point(parsedParameters[3],parsedParameters[4],parsedParameters[5]);
        Point third = new Point(parsedParameters[6],parsedParameters[7],parsedParameters[8]);
        Point fourth = new Point(parsedParameters[9],parsedParameters[10],parsedParameters[11]);
        return new Tetrahedron(first,second,third,fourth);
    }

}
