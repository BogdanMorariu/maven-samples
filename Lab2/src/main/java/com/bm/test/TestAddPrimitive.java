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
public class TestAddPrimitive {

    @State(Scope.Benchmark)
    public static class BeforeStatePrimitive {
        long aLong;

        @Setup(Level.Invocation)
        public void generateOrder(SizeStatePrimitive sizeState) {
            aLong = sizeState.before.get();
        }

        @TearDown(Level.Invocation)
        public void removeOrder(RepositoryPrimitiveState repositoryState) {
            repositoryState.primitives.remove(aLong);
        }
    }

    @State(Scope.Benchmark)
    public static class AfterStatePrimitive {
        long aLong;

        @Setup(Level.Invocation)
        public void generateOrder(SizeStatePrimitive sizeState) {
            aLong = sizeState.after.get();
        }

        @TearDown(Level.Invocation)
        public void removeOrder(RepositoryPrimitiveState repositoryState) {
            repositoryState.primitives.remove(aLong);
        }
    }

    @State(Scope.Benchmark)
    public static class ExistingStatePrimitive {
        long aLong;

        @Setup(Level.Invocation)
        public void generateOrder(SizeStatePrimitive sizeState) {
            aLong = sizeState.existing.get();
        }

        @TearDown(Level.Invocation)
        public void removeOrder(RepositoryPrimitiveState repositoryState) {
            repositoryState.primitives.remove(aLong);
        }
    }

    //Primitive
    @Benchmark
    public void add_primitive_before(RepositoryPrimitiveState repositoryState, BeforeStatePrimitive before) {
        repositoryState.primitives.add(before.aLong);
    }

    @Benchmark
    public void add_primitive_existing(RepositoryPrimitiveState repositoryState, ExistingStatePrimitive existing) {
        repositoryState.primitives.add(existing.aLong);
    }

    @Benchmark
    public void add_primitive_after(RepositoryPrimitiveState repositoryState, AfterStatePrimitive after) {
        repositoryState.primitives.add(after.aLong);
    }
}
