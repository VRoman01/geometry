package com.epam.geometry.entity.repository;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Tetrahedron;


public class TetrahedronForRep extends Tetrahedron {

    private int id;
    private String name;

    public TetrahedronForRep(int id, String name, Point first, Point second, Point third, Point fourth) {
        super(first, second, third, fourth);
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
