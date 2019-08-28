package com.epam.geometry.entity.observer;


public interface Observable {

    void notifyObserver();

    void attach(Observer o);

    void detach(Observer o);
}
