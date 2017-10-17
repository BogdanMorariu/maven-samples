package com.bm.repository;

import java.util.HashMap;
import java.util.Map;

public class HashSetBasedRepository<T> implements InMemoryRepository<T> {

    private Map<T,Integer> map;
    private Integer id;

    public HashSetBasedRepository() {
        this.map = new HashMap<>();
        this.id = 0;
    }

    @Override
    public void add(T element) {
        map.put(element,id++);
    }

    @Override
    public void remove(T element) {
        map.remove(element);
    }

    @Override
    public boolean contains(T element) {
        return map.containsKey(element);
    }
}
