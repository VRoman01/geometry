package com.epam.geometry.entity.observer;

import java.util.Objects;

public class ParametersTetrahedron {

    private final double area;
    private final double volume;
    private final boolean touchesAnyCoordinatePlane;

    public ParametersTetrahedron(double area, double volume, boolean touchesAnyCoordinatePlane) {
        this.area = area;
        this.volume = volume;
        this.touchesAnyCoordinatePlane = touchesAnyCoordinatePlane;
    }

    public final double getArea() {
        return area;
    }

    public final double getVolume() {
        return volume;
    }

    public final boolean isTouchesAnyCoordinatePlane() {
        return touchesAnyCoordinatePlane;
    }

    @Override
    public String toString() {
        return getClass().getName() + '@' +
                "area: " + area +
                ", volume: " + volume +
                ", touchesAnyCoordinatePlane: " + touchesAnyCoordinatePlane;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParametersTetrahedron that = (ParametersTetrahedron) o;
        return Double.compare(that.area, area) == 0 &&
                Double.compare(that.volume, volume) == 0 &&
                touchesAnyCoordinatePlane == that.touchesAnyCoordinatePlane;
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, volume, touchesAnyCoordinatePlane);
    }
}