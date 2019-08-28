package com.epam.geometry.creator.util;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class LogicValidatorTest {

    private final LogicValidator validator = new LogicValidator();

    @DataProvider
    public static Object[][] data_provider_is_tetrahedron() {
        return new Object[][]{
                {new double[]{1.0, -1.0, 1, 2, 2, 3, 3, 1, 3, 0, 0, 1}, false},
                {new double[]{2, 3, 1, 4, 1, -2, 6, 3, 7, -5, -4, 8}, true},
        };
    }

    @Test
    @UseDataProvider("data_provider_is_tetrahedron")
    public void test_return_false_and_true_on_valid_and_invalid_array(double[] array, boolean expect){
        boolean actual = validator.isTetrahedron(array);
        assertEquals(expect, actual);
    }

}