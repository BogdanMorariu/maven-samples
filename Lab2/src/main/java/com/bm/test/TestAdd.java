package com.bm.test;

import com.bm.model.Order;
import com.bm.state.RepositoryState;
import com.bm.state.SizeState;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 10, time = 1)
@Fork(1)
public class TestAdd {

    @State(Scope.Benchmark)
    public static class BeforeState {
        Order order;

        @Setup(Level.Invocation)
        public void generateOrder(SizeState sizeState) {
            order = sizeState.before.get();
        }

        @TearDown(Level.Invocation)
        public void removeOrder(RepositoryState repositoryState) {
            repositoryState.orders.remove(order);
        }
    }

    @State(Scope.Benchmark)
    public static class AfterState {
        Order order;

        @Setup(Level.Invocation)
        public void generateOrder(SizeState sizeState) {
            order = sizeState.after.get();
        }

        @TearDown(Level.Invocation)
        public void removeOrder(RepositoryState repositoryState) {
            repositoryState.orders.remove(order);
        }
    }

    @State(Scope.Benchmark)
    public static class ExistingState {
        Order order;

        @Setup(Level.Invocation)
        public void generateOrder(SizeState sizeState) {
            order = sizeState.existing.get();
        }

        @TearDown(Level.Invocation)
        public void removeOrder(RepositoryState repositoryState) {
            repositoryState.orders.remove(order);
        }
    }

    @Benchmark
    public void add_before(RepositoryState repositoryState, BeforeState before) {
        repositoryState.orders.add(before.order);
    }

    @Benchmark
    public void add_existing(RepositoryState repositoryState, ExistingState existing) {
        repositoryState.orders.add(existing.order);
    }

    @Benchmark
    public void add_after(RepositoryState repositoryState, AfterState after) {
        repositoryState.orders.add(after.order);
    }




}