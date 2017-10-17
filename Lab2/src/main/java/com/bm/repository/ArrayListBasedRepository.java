package com.bm.repository;

import java.util.ArrayList;
import java.util.List;

public class ArrayListBasedRepository<T> implements InMemoryRepository<T> {

    private List<T> repo;

    public ArrayListBasedRepository() {
        repo = new ArrayList<>();
    }

    @Override
    public void add(T element) {
        repo.add(element);
    }

    @Override
    public void remove(T element) {
        repo.remove(element);
    }

    @Override
    public boolean contains(T element) {
        return repo.contains(element);
    }
}
