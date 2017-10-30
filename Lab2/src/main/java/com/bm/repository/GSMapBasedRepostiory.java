package com.bm.repository;

import org.eclipse.collections.impl.factory.Maps;

import java.util.Map;

public class GSMapBasedRepostiory<T> implements InMemoryRepository<T> {
    private Map<T,Integer> map;
    private Integer id;

    public GSMapBasedRepostiory() {
        this.map = Maps.mutable.empty();
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
