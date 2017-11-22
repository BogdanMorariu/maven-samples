package com.bm.state;

import com.bm.repository.InMemoryRepositoryPrimitive;
import com.bm.repository.RepositorySupplierPrimitive;
import org.openjdk.jmh.annotations.*;

import java.util.stream.IntStream;

@State(Scope.Benchmark)
public class RepositoryPrimitiveState{
    @Param
    private RepositorySupplierPrimitive repositorySupplierPrimitive;

    public InMemoryRepositoryPrimitive primitives;

    /* run before each benchmark */
    @Setup
    public void setUp(SizeState sizeState2) {
        primitives = repositorySupplierPrimitive.get();
        System.out.println(primitives.getClass().getSimpleName() + " > setup > populate");

        IntStream.rangeClosed(1, sizeState2.size)
                .forEach(primitives::add);
    }

    /* run after each benchmark */
    @TearDown
    public void tearDown() {
        System.out.println(primitives.getClass().getSimpleName() + " > teardown > clear");
        primitives.clear();
        System.gc();
    }
}
