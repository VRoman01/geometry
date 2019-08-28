package com.epam.geometry.entity;

public class Point {
    private final double x;
    private final double y;
    private final double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distance(Point other){
        return Math.sqrt(
                Math.pow(x-other.getX(), 2) +
                Math.pow(y-other.getY(), 2) +
                Math.pow(z-other.getZ(), 2)
        );
    }

    public final double getX() {
        return x;
    }

    public final double getY() {
        return y;
    }

    public final double getZ() {
        return z;
    }

    @Override
    public String toString() {
        return getClass().getName() + '@' +
                "x: " + x +
                ", y: " + y +
                ", z: " + z;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Point other = (Point) obj;
        if (x != other.x || y != other.y || z != other.z) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return 3 * Double.hashCode(x) + 7 * Double.hashCode(y) + 13 * Double.hashCode(z);
    }

}
