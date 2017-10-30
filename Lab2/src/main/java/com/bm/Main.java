package com.bm;

import com.bm.test.TestAdd;
import com.bm.test.TestContains;
import com.bm.test.TestRemove;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class Main {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(TestAdd.class.getSimpleName()+".*")
                .include(TestRemove.class.getSimpleName()+".*")
                .include(TestContains.class.getSimpleName()+".*")
                .build();

        new Runner(opt).run();
    }
}
