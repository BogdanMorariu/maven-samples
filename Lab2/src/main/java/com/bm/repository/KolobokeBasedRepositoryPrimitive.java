package com.bm.repository;

import com.koloboke.collect.map.hash.HashIntIntMap;
import com.koloboke.collect.map.hash.HashLongIntMap;
import com.koloboke.collect.map.hash.HashLongIntMaps;

public class KolobokeBasedRepositoryPrimitive implements InMemoryRepositoryPrimitive {

    private HashLongIntMap map;
    private Integer id;

    public KolobokeBasedRepositoryPrimitive(){
        map = HashLongIntMaps.newUpdatableMap();
        id = 0;
    }

    @Override
    public void add(long e) {
        map.addValue(e,id++);
    }

    @Override
    public boolean contains(long e) {
        return map.containsKey(e);
    }

    @Override
    public void remove(long e) {
        map.remove(e)
    }

    @Override
    public void clear() {
        map.clear();
    }
}
