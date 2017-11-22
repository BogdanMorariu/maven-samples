package com.bm.test;

import com.bm.model.Order;
import com.bm.state.RepositoryPrimitiveState;
import com.bm.state.RepositoryState;
import com.bm.state.SizeState;
import com.bm.state.SizeStatePrimitive;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 10, time = 1)
@Fork(1)
public class TestContainsPrimitive {

    @State(Scope.Benchmark)
    public static class ExistingStatePrimitive {
        long aLong;

        @Setup(Level.Invocation)
        public void generateOrder(SizeStatePrimitive sizeState) {
            aLong = sizeState.existing.get();
        }
    }

    @Benchmark
    public void contains_primitive_existing(RepositoryPrimitiveState repositoryState, ExistingStatePrimitive existing) {
        repositoryState.primitives.contains(existing.aLong);
    }
}
