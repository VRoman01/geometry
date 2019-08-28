package com.epam.geometry.calculator;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Tetrahedron;
import com.epam.geometry.entity.Vector;
import java.util.stream.DoubleStream;

public class TetrahedronCalculator {

    private static VectorCalculator calculator = new VectorCalculator();

    public double volume(Tetrahedron t){

        Vector v1 = new Vector(t.getFirst().getX()-t.getSecond().getX(), t.getFirst().getY() - t.getSecond().getY(),t.getFirst().getZ()-t.getSecond().getZ());
        Vector v2 = new Vector(t.getFirst().getX()-t.getThird().getX(), t.getFirst().getY() - t.getThird().getY(),t.getFirst().getZ()-t.getThird().getZ());
        Vector v3 = new Vector(t.getFirst().getX()-t.getFourth().getX(), t.getFirst().getY() - t.getFourth().getY(),t.getFirst().getZ()-t.getFourth().getZ());

        return Math.abs(calculator.tripleMultiplication(v1,v2,v3))/6;
    }

    public double area(Tetrahedron t){

        Vector v1 = new Vector(t.getFirst().getX()-t.getSecond().getX(), t.getFirst().getY() - t.getSecond().getY(),t.getFirst().getZ()-t.getSecond().getZ());
        Vector v2 = new Vector(t.getFirst().getX()-t.getThird().getX(), t.getFirst().getY() - t.getThird().getY(),t.getFirst().getZ()-t.getThird().getZ());
        Vector v3 = new Vector(t.getFirst().getX()-t.getFourth().getX(), t.getFirst().getY() - t.getFourth().getY(),t.getFirst().getZ()-t.getFourth().getZ());
        Vector v4 = new Vector(t.getSecond().getX()-t.getFourth().getX(), t.getSecond().getY() - t.getFourth().getY(),t.getSecond().getZ()-t.getFourth().getZ());
        Vector v5 = new Vector(t.getThird().getX()-t.getFourth().getX(), t.getThird().getY() - t.getFourth().getY(),t.getThird().getZ()-t.getFourth().getZ());

        double s1 = calculator.vectorMultiplication(v1,v2).length();
        double s2 = calculator.vectorMultiplication(v1,v3).length();
        double s3 = calculator.vectorMultiplication(v3,v2).length();
        double s4 = calculator.vectorMultiplication(v4,v5).length();

        return (s1+s2+s3+s4)/2;
    }

    public boolean isTouchesAnyCoordinatePlane(Tetrahedron t){

        double[] arr1 = DoubleStream.of(t.getFirst().getX(),t.getSecond().getX(),t.getThird().getX(),t.getFourth().getX())
                .filter(x -> x == 0).toArray();
        double[] arr2 = DoubleStream.of(t.getFirst().getY(),t.getSecond().getY(),t.getThird().getY(),t.getFourth().getY())
                .filter(x -> x == 0).toArray();
        double[] arr3 = DoubleStream.of(t.getFirst().getZ(),t.getSecond().getZ(),t.getThird().getZ(),t.getFourth().getZ())
                .filter(x -> x == 0).toArray();

        if (arr1.length == 3 || arr2.length == 3 || arr3.length == 3){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new TetrahedronCalculator().area(new Tetrahedron(
                new Point(0,1,-1),new Point(0,2,-11),
                new Point(2,3,2),new Point(0,-3,9))));
    }
}



