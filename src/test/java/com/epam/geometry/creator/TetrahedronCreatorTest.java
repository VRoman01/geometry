package com.epam.geometry.creator;

import static org.mockito.Mockito.*;

import com.epam.geometry.creator.util.FormatValidator;
import com.epam.geometry.creator.util.LogicValidator;
import com.epam.geometry.creator.util.Parser;
import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Tetrahedron;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(DataProviderRunner.class)
public class TetrahedronCreatorTest {

    private static TetrahedronCreator creator;
    private static FormatValidator formatValidator;
    private static LogicValidator logicValidator;
    private static Parser parser;
    @Before
    public void create_mock() {
        formatValidator = mock(FormatValidator.class);
        logicValidator = mock(LogicValidator.class);
        parser = mock(Parser.class);
        creator = new TetrahedronCreator(formatValidator, parser, logicValidator);
    }

    private static final String VALID_DATA_FOR_FIRST_TETRAHEDRON = "2 3 1 4 1 -2 6 3 7 -5 -4 8";
    private static final String VALID_DATA_FOR_SECOND_TETRAHEDRON = "0 0 0 1 1 1 2 2 2 3 3 3";
    private static final double[] ARRAY_FIRST_TETRAHEDRON = new double[]{2, 3, 1, 4, 1, -2, 6, 3, 7, -5, -4, 8};
    private static final double[] ARRAY_SECOND_TETRAHEDRON = new double[]{0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3};

    private static final String INVALID_DATA_FOR_FIRST_TETRAHEDRON = "1.0 -1.0 1 2 2 3 3 1 3 0 0 1";
    private static final String INVALID_DATA_FOR_SECOND_TETRAHEDRON = "ghfgn gdf";
    private static final double[] INVALID_ARRAY_FIRST_TETRAHEDRON = new double[]{1.0, -1.0, 1, 2, 2, 3, 3, 1, 3, 0, 0, 1};


    private static final List<Tetrahedron> TETRAHEDRONS = Arrays.asList(
            new Tetrahedron(
                    new Point(2, 3, 1),
                    new Point(4, 1, -2),
                    new Point(6, 3, 7),
                    new Point(-5, -4, 8)
            ),
            new Tetrahedron(
                    new Point(0, 0, 0),
                    new Point(1, 1, 1),
                    new Point(2, 2, 2),
                    new Point(3, 3, 3)
            )
    );

    @DataProvider
    public static Object[][] valid_data_provider_create() {
        return new Object[][]{
                {VALID_DATA_FOR_FIRST_TETRAHEDRON, TETRAHEDRONS.get(0)},
                {VALID_DATA_FOR_SECOND_TETRAHEDRON, TETRAHEDRONS.get(1)}
        };
    }
    @Test
    @UseDataProvider("valid_data_provider_create")
    public void test_create_two_tetrahedron_according_valid_data(String validData, Tetrahedron expect) {

        when(formatValidator.isValid(validData)).thenReturn(true);
        when(parser.parseDoubles(VALID_DATA_FOR_FIRST_TETRAHEDRON)).thenReturn(ARRAY_FIRST_TETRAHEDRON);
        when(parser.parseDoubles(VALID_DATA_FOR_SECOND_TETRAHEDRON)).thenReturn(ARRAY_SECOND_TETRAHEDRON);
        when(logicValidator.isTetrahedron(ARRAY_FIRST_TETRAHEDRON)).thenReturn(true);
        when(logicValidator.isTetrahedron(ARRAY_SECOND_TETRAHEDRON)).thenReturn(true);


        Optional<Tetrahedron> actual = creator.create(validData);
        assertTrue(actual.isPresent());
        assertEquals(expect, actual.get());
    }


    @DataProvider
    public static Object[][] invalid_data_provider_create(){
        return new Object[][]{
                {INVALID_DATA_FOR_FIRST_TETRAHEDRON, 1},
                {INVALID_DATA_FOR_SECOND_TETRAHEDRON, 0}
        };
    }
    @Test
    @UseDataProvider("invalid_data_provider_create")
    public void test_empty_object_according_invalid_data(String invalidData, int expectedParserAndLogicValidatorInvocations){
        when(formatValidator.isValid(INVALID_DATA_FOR_FIRST_TETRAHEDRON)).thenReturn(true);
        when(formatValidator.isValid(INVALID_DATA_FOR_SECOND_TETRAHEDRON)).thenReturn(false);
        when(parser.parseDoubles(INVALID_DATA_FOR_FIRST_TETRAHEDRON)).thenReturn(INVALID_ARRAY_FIRST_TETRAHEDRON);
        when(logicValidator.isTetrahedron(INVALID_ARRAY_FIRST_TETRAHEDRON)).thenReturn(false);

        Optional<Tetrahedron> actual = creator.create(invalidData);
        Optional<Tetrahedron> expect = Optional.empty();
        assertEquals(expect, actual);
        verify(parser, times(expectedParserAndLogicValidatorInvocations)).parseDoubles(any());
        verify(logicValidator, times(expectedParserAndLogicValidatorInvocations)).isTetrahedron(any());


    }






}