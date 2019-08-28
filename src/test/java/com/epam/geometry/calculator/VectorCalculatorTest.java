package com.epam.geometry.calculator;

import com.epam.geometry.entity.Vector;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class VectorCalculatorTest {

    private VectorCalculator calculator = new VectorCalculator();
    private static final Vector[] vectors = new Vector[]{
            new Vector(-1, 2, 10),
            new Vector(3, 5, 1),
            new Vector(4,6,3),
            new Vector(1,1,1)
    };


    @DataProvider
    public static Object[][] data_provider_scalar_vectors_multiplication(){
        return new Object[][] {
                {vectors[0],vectors[1], 17, new Vector(-48,31,-11)},
                {vectors[0],vectors[2], 38, new Vector(-54,43,-14)},
                {vectors[1],vectors[2], 45, new Vector(9,-5,-2)}
        };
    }
    @Test
    @UseDataProvider("data_provider_scalar_vectors_multiplication")
    public void test_scalar_vectors_multiplication(Vector v1, Vector v2, double scalarMultiplication, Vector vectorMultiplication){
        Assert.assertTrue(calculator.scalarMultiplication(v1,v2) == scalarMultiplication);
        Assert.assertEquals(calculator.vectorMultiplication(v1,v2), vectorMultiplication);
    }


    @DataProvider
    public static Object[][] data_provider_triple_multiplication(){
        return new Object[][] {
                {vectors[0],vectors[1], vectors[2], -39},
                {vectors[0],vectors[1], vectors[3], -28},
                {vectors[2],vectors[1], vectors[3], -2}
        };
    }
    @Test
    @UseDataProvider("data_provider_triple_multiplication")
    public void test_triple_vectors_multiplication(Vector v1, Vector v2, Vector v3, double multiplication){
        Assert.assertTrue(calculator.tripleMultiplication(v1,v2,v3) == multiplication);
    }



}