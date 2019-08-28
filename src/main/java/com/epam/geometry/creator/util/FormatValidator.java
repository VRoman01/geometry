package com.epam.geometry.creator.util;


public class FormatValidator {

    private static final String VALID_PARAMETERS_REGEX = "((-?(0|([1-9]\\d*))(\\.\\d+)?)\\s){12}";


    public boolean isValid(String parameters){
        return (parameters != null) && parameters.matches(VALID_PARAMETERS_REGEX);
    }

}
