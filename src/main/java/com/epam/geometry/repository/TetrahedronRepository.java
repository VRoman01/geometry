package com.epam.geometry.repository;

import com.epam.geometry.entity.repository.TetrahedronForRep;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TetrahedronRepository implements AbstractRepository<TetrahedronForRep>{

    List<TetrahedronForRep> repository = new ArrayList<>();

    @Override
    public void add(TetrahedronForRep tetrahedronForRep) {
        if (!containID(tetrahedronForRep)){
            repository.add(tetrahedronForRep);
        }

    }

    @Override
    public void remove(TetrahedronForRep tetrahedronForRep) {
        if (containID(tetrahedronForRep)){
            repository.remove(tetrahedronForRep);
        }
    }

    @Override
    public void update(TetrahedronForRep tetrahedronForRep) {
        if (containID(tetrahedronForRep)){
            repository.remove(tetrahedronForRep.getId());
            repository.add(tetrahedronForRep);
        }
    }

    @Override
    public List<TetrahedronForRep> query(SpecificationShape<TetrahedronForRep> specification) {
        return repository.stream()
                .filter(specification::specified)
                .collect(Collectors.toList());
    }

    public void sort(Comparator<TetrahedronForRep> comparator) {
        repository.sort(comparator);
    }

    private boolean containID(TetrahedronForRep tetrahedronForRep) {
        int id = tetrahedronForRep.getId();
        for (TetrahedronForRep t: repository){
            if (t.getId() == id){
                return true;
            }
        }
        return false;
    }

}
