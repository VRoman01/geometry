package com.epam.geometry.repository;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.repository.TetrahedronForRep;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.junit.Assert.*;


@RunWith(DataProviderRunner.class)
public class TetrahedronRepositoryTest {


    private static TetrahedronForRep t1;
    private static TetrahedronForRep t2;
    private static TetrahedronForRep t3;
    private static TetrahedronForRep t4;
    static {
        t1 = new TetrahedronForRep(1,"first", new Point(1,2,3),new Point(1,2,0),new Point(1,0,3),new Point(0,2,3));
        t2 = new TetrahedronForRep(2,"second", new Point(10,2,3),new Point(-1,20,0),new Point(-1,0,30),new Point(0,2,3));
        t3 = new TetrahedronForRep(3,"third", new Point(1,20,3),new Point(-1,2,0),new Point(1,0,-30),new Point(0,2,3));
        t4 = new TetrahedronForRep(4,"fourth", new Point(-10,2,3),new Point(-10,2,0),new Point(-1,0,3),new Point(0,2,3));
        }
    private static TetrahedronRepository repository = new TetrahedronRepository();
    static {
        repository.add(t1);
        repository.add(t2);
        repository.add(t3);
        repository.add(t4);
    }

    @DataProvider
    private static Object[][] data_provider_search_id_name(){
        return new Object[][]{
                {Arrays.asList(t1),1,"first"},
                {Arrays.asList(t2),2,"second"},
                {Arrays.asList(t3),3,"third"},
                {Arrays.asList(t4),4,"fourth"}
        };
    }
    @Test
    @UseDataProvider("data_provider_search_id_name")
    public void test(List<TetrahedronForRep> expectList, int expectID, String expectName){
        List<TetrahedronForRep> actualList = new ArrayList<>();
        Assert.assertTrue(expectList.stream().collect( groupingBy( k -> k, counting()) )
                .equals( actualList.stream().collect( groupingBy( k -> k, counting()) ) ));
    }

}