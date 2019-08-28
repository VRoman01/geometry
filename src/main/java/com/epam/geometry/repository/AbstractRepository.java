package com.epam.geometry.repository;

import com.epam.geometry.entity.Shape;
import java.util.List;

public interface AbstractRepository<T extends Shape>{

    void add(T t);

    void remove(T t);

    void update(T t);

    List<T> query(SpecificationShape<T> specification);

}
