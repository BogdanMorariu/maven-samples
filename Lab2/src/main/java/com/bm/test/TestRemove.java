package com.bm.test;

import com.bm.model.Order;
import com.bm.state.RepositoryState;
import com.bm.state.SizeState;
import org.openjdk.jmh.annotations.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 10, time = 1)
@Fork(1)
public class TestRemove {

    @State(Scope.Benchmark)
    public static class ExistingState {
        Order aLong;

        @Setup(Level.Invocation)
        public void generateOrder(SizeState sizeState) {
            aLong = sizeState.existing.get();
        }

        @TearDown(Level.Invocation)
        public void addOrder(RepositoryState repositoryState) {
            repositoryState.orders.add(aLong);
        }
    }

    @State(Scope.Benchmark)
    public static class LastState {
        Order aLong;

        @Setup(Level.Invocation)
        public void generateOrder(SizeState sizeState) {
            aLong = sizeState.last.get();
        }

        @TearDown(Level.Invocation)
        public void addOrder(RepositoryState repositoryState) {
            if(!(repositoryState instanceof Map))
                repositoryState.orders.add(aLong);
        }
    }

    @Benchmark
    public void remove_existing(RepositoryState repositoryState, ExistingState existing) {
        repositoryState.orders.remove(existing.aLong);
    }

    @Benchmark
    public void remove_last(RepositoryState repositoryState, LastState last) {
        repositoryState.orders.remove(last.aLong);
    }
}
