package com.bm.repository;

import com.koloboke.collect.map.hash.HashObjIntMaps;
import java.util.Map;

public class KolobokeBasedRepository<T> implements InMemoryRepository<T>{

    private Map<T,Integer> map;
    private Integer id;

    public KolobokeBasedRepository(){
        map = HashObjIntMaps.newUpdatableMap();
        id = 0;
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
