package com.epam.geometry.creator.util;

public class LogicValidator {

    public boolean isTetrahedron(double[] parameters){

        final double x0 = parameters[0];
        final double y0 = parameters[1];
        final double z0 = parameters[2];
        final double x1 = parameters[3];
        final double y1 = parameters[4];
        final double z1 = parameters[5];
        final double x2 = parameters[6];
        final double y2 = parameters[7];
        final double z2 = parameters[8];
        final double x3 = parameters[9];
        final double y3 = parameters[10];
        final double z3 = parameters[11];

        final double v1x = x1-x0;
        final double v1y = y1-y0;
        final double v1z = z1-z0;

        final double v2x = x2-x0;
        final double v2y = y2-y0;
        final double v2z = z2-z0;

        final double v3x = x3-x0;
        final double v3y = y3-y0;
        final double v3z = z3-z0;

        final double volume = v1x*(v2y*v3z - v2z*v3y)
                             -v1y*(v2x*v3z - v2z*v3x)
                             +v1z*(v2x*v3y - v2y*v3x);
        return volume != 0;
    }

}
