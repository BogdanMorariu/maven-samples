package com.bm.state;

import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

@State(Scope.Benchmark)
public class SizeStatePrimitive {
    @Param({"100","10000"})
    public int size;

    public Supplier<Long> existing = new Supplier<Long>() {
        private final Random random = new Random();
        @Override
        public Long get() {
            return (long) random.nextInt(size);
        }
    };

    public Supplier<Long> before = new Supplier<Long>() {
        private final AtomicInteger currentSize = new AtomicInteger(size);
        @Override
        public Long get() {
            return (long) currentSize.decrementAndGet();
        }
    };

    public Supplier<Long> after = new Supplier<Long>() {
        private final AtomicInteger currentSize = new AtomicInteger(size);
        @Override
        public Long get() {
            return (long) currentSize.incrementAndGet();
        }
    };

    public Supplier<Long> last = new Supplier<Long>() {
        private final AtomicInteger currentSize = new AtomicInteger(size);
        @Override
        public Long get() {
            return (long) currentSize.get();
        }
    };
}
