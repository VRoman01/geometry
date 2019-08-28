package com.epam.geometry.creator.util;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(DataProviderRunner.class)
public class ParserTest {

    private static final double DELTA = 1e-10;

    private Parser parser = new Parser();

    @DataProvider
    public static Object[][] dataProviderParseDouble(){
        return new Object[][] {
                {"3 -4", new double[] {3, -4}},
                {"5.6 -6.7", new double[] {5.6, -6.7}},
                {"0.1", new double[] {0.1}},
                {"", new double[] {0}}
        };
    }

    @Test
    @UseDataProvider("dataProviderParseDouble")
    public void testReturnArrayDoubleWhenGivenString(String stringForParsing, double[] expectDoubleArray) {

        double[] actualDoubleArray = parser.parseDoubles(stringForParsing);

        Assert.assertArrayEquals(expectDoubleArray, actualDoubleArray, DELTA);
    }



}