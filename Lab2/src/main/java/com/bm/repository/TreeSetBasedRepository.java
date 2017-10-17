package com.bm.repository;

import java.util.TreeSet;

public class TreeSetBasedRepository<T> implements InMemoryRepository<T> {

    private TreeSet<T> tree;

    public TreeSetBasedRepository() {
        this.tree = new TreeSet<>();
    }

    @Override
    public void add(T element) {
        tree.add(element);
    }

    @Override
    public void remove(T element) {
        tree.remove(element);
    }

    @Override
    public boolean contains(T element) {
        return tree.contains(element);
    }
}
