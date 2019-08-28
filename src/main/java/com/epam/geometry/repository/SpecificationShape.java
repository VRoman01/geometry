package com.epam.geometry.repository;

import com.epam.geometry.entity.Shape;

public interface SpecificationShape<T extends Shape> {

    boolean specified(T t);

}
