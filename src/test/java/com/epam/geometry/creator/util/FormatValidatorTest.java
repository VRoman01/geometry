package com.epam.geometry.creator.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FormatValidatorTest {

    private final FormatValidator validator = new FormatValidator();

    private final String VALID = "12 -4 6.0 5.4 -56.6 67.9 12 -4 6.0 5.4 -56.6 67.9 ";
    private final String INVALID = "12f -4 6.0 5.4 -56.6 67.9 12 -4 6.0 5.4 -56.6 67.9";

    @Test
    public void testForCorrectData(){
        Assert.assertTrue(validator.isValid(VALID));
    }

    @Test
    public void testForIncorrectData(){
        Assert.assertFalse(validator.isValid(INVALID));
    }


}