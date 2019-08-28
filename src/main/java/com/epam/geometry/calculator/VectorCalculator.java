package com.epam.geometry.calculator;

import com.epam.geometry.entity.Vector;

public class VectorCalculator {

    public double scalarMultiplication(Vector v1, Vector v2){
        return v1.getX()*v2.getX() + v1.getY()*v2.getY() + v1.getZ()*v2.getZ();
    }

    public Vector vectorMultiplication(Vector v1, Vector v2){

        final double x = v1.getY()*v2.getZ()-v1.getZ()*v2.getY();
        final double y = v1.getZ()*v2.getX()-v1.getX()*v2.getZ();
        final double z = v1.getX()*v2.getY()-v1.getY()*v2.getX();
        return new Vector(x,y,z);
    }

    public double tripleMultiplication(Vector v1, Vector v2, Vector v3){
        return v3.getX()*(v1.getY()*v2.getZ()-v1.getZ()*v2.getY())+
                v3.getY()*(v1.getZ()*v2.getX()-v1.getX()*v2.getZ())+
                v3.getZ()*(v1.getX()*v2.getY()-v1.getY()*v2.getX());
    }
}
