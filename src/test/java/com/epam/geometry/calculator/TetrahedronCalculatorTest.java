package com.epam.geometry.calculator;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Tetrahedron;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(DataProviderRunner.class)
public class TetrahedronCalculatorTest {

    private TetrahedronCalculator calculator = new TetrahedronCalculator();
    private static final Tetrahedron[] tetrahedrons = {
            new Tetrahedron(
                    new Point(2,-1,1),new Point(5,5,4),
                    new Point(3,2,-1),new Point(4,1,3)),
            new Tetrahedron(
                    new Point(0,1,-1),new Point(0,2,-11),
                    new Point(2,3,2),new Point(0,-3,9))
    };

    @DataProvider
    public static Object[][] data_provider_tetrahedron_volume_area_belongs_coordinate_plane(){
        return new Object[][] {
                {tetrahedrons[0], 3, 30.9, false},
                {tetrahedrons[1], 10, 96.7,true}
        };
    }

    @Test
    @UseDataProvider("data_provider_tetrahedron_volume_area_belongs_coordinate_plane")
    public void test_tetrahedron_volume_area_belongs_coordinate_plane(Tetrahedron t,
                                                                      double volume,
                                                                      double area,
                                                                      boolean belongsAnyPlane){
        Assert.assertEquals(calculator.volume(t), volume,0.1);
        Assert.assertEquals(calculator.area(t), area,0.1);
        Assert.assertEquals(calculator.isTouchesAnyCoordinatePlane(t),belongsAnyPlane);

    }

}