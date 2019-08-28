package com.epam.geometry.entity.observer;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Tetrahedron;
import java.util.ArrayList;
import java.util.List;

public class TetrahedronObservable extends Tetrahedron implements Observable {

    private List<Observer> observers = new ArrayList<>();
    private int id;

    public TetrahedronObservable(int id, Point first, Point second, Point third, Point fourth) {
        super(first, second, third, fourth);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifyObserver();

    }

    @Override
    public void setFirst(Point first) {
        super.setFirst(first);
        notifyObserver();
    }

    @Override
    public void setSecond(Point second) {
        super.setSecond(second);
        notifyObserver();
    }

    @Override
    public void setThird(Point third) {
        super.setThird(third);
        notifyObserver();
    }

    @Override
    public void setFourth(Point fourth) {
        super.setFourth(fourth);
        notifyObserver();
    }

    @Override
    public void notifyObserver() {
        observers.stream().forEach(x->x.update(this));
    }

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }
}
