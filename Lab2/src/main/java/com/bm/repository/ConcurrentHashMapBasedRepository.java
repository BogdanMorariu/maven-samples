package com.bm.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapBasedRepository<T> implements InMemoryRepository<T>{

    private Map<T,Integer> map ;
    private Integer id;

    public ConcurrentHashMapBasedRepository() {
        this.map = new ConcurrentHashMap<>();
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

    @Override
    public void clear() {
        map.clear();
    }
}
