package com.bm.repository;

public interface InMemoryRepositoryPrimitive{
    void add(long e);

    boolean contains(long e);

    void remove(long e);

    void clear();
}
