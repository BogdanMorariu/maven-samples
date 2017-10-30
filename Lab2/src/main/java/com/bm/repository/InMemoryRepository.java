package com.bm.repository;

import java.util.ArrayList;
import java.util.List;

public interface InMemoryRepository<T> {

    void add(T element);
    void remove(T element);
    boolean contains(T element);
    void clear();
}
