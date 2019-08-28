package com.epam.geometry.creator.util;

import java.util.Arrays;

public class Parser {

    private static final String SPLIT_REGEX = "\\s";

    public double[] parseDoubles(String stringForParsing) {

        return Arrays
                .stream(stringForParsing.split(SPLIT_REGEX))
                .map(x -> x.equals("") ? "0" : x)
                .mapToDouble(Double::parseDouble)
                .toArray();
    }
}
