package com.bm;

import com.bm.test.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class Main {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                //.include(TestAddPrimitive.class.getSimpleName()+".*")
                //.include(TestRemove.class.getSimpleName()+".*")
                .include(TestContains.class.getSimpleName()+".*")
                .include(TestContainsPrimitive.class.getSimpleName()+".*")
                .build();

        new Runner(opt).run();
    }
}
