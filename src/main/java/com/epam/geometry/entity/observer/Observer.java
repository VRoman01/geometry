package com.epam.geometry.entity.observer;

public interface Observer<T extends Observable> {

    void update(T t);
}
