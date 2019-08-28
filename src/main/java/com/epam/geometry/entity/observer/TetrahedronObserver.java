package com.epam.geometry.entity.observer;

import com.epam.geometry.calculator.TetrahedronCalculator;

import java.util.HashMap;
import java.util.Map;

public class TetrahedronObserver implements Observer<TetrahedronObservable> {

    private Map<Integer, ParametersTetrahedron> map = new HashMap<>();
    private TetrahedronCalculator calculator = new TetrahedronCalculator();


    @Override
    public void update(TetrahedronObservable tetrahedronObservable) {
        int id = tetrahedronObservable.getId();
        double volume = calculator.volume(tetrahedronObservable);
        double area = calculator.area(tetrahedronObservable);
        boolean isTouchesAnyCoordinatePlane = calculator.isTouchesAnyCoordinatePlane(tetrahedronObservable);
        ParametersTetrahedron parameters = new ParametersTetrahedron(volume, area, isTouchesAnyCoordinatePlane);
        map.put(id, parameters);
    }
}
