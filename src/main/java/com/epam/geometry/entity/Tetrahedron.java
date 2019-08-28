package com.epam.geometry.entity;

import java.util.Objects;

public class Tetrahedron implements Shape {

    private Point first;
    private Point second;
    private Point third;
    private Point fourth;

    public Tetrahedron(Point first, Point second, Point third, Point fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

    public Point getFirst() {
        return first;
    }

    public void setFirst(Point first) {
        this.first = first;
    }

    public Point getSecond() {
        return second;
    }

    public void setSecond(Point second) {
        this.second = second;
    }

    public Point getThird() {
        return third;
    }

    public void setThird(Point third) {
        this.third = third;
    }

    public Point getFourth() {
        return fourth;
    }

    public void setFourth(Point fourth) {
        this.fourth = fourth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tetrahedron that = (Tetrahedron) o;
        return first.equals(that.first) &&
                second.equals(that.second) &&
                third.equals(that.third) &&
                fourth.equals(that.fourth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third, fourth);
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" +
                "Tetrahedron{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                ", fourth=" + fourth +
                '}';
    }
}
