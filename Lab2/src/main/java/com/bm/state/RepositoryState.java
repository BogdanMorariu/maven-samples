package com.bm.state;

import com.bm.model.Order;
import com.bm.repository.InMemoryRepository;
import com.bm.repository.RepositorySupplier;
import org.openjdk.jmh.annotations.*;
import java.util.stream.IntStream;

@State(Scope.Benchmark)
public class RepositoryState {
    @Param
    private RepositorySupplier repositorySupplier;

    public InMemoryRepository<Order> orders;

    /* run before each benchmark */
    @Setup
    public void setUp(SizeState sizeState) {
        orders = repositorySupplier.get();
        System.out.println(orders.getClass().getSimpleName() + " > setup > populate");

        IntStream.rangeClosed(1, sizeState.size)
                .mapToObj(Order::new)
                .forEach(orders::add);
    }

    /* run after each benchmark */
    @TearDown
    public void tearDown() {
        System.out.println(orders.getClass().getSimpleName() + " > teardown > clear");
        orders.clear();
        System.gc();
    }
}
