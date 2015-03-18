/**
 * Copyright 2014 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package rx.observables;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import rx.jmh.InputWithIncrementingInteger;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Thread)
public class BlockingObservablePerf {

    @State(Scope.Thread)
    public static class MultiInput extends InputWithIncrementingInteger {

        @Param({ "1", "1000", "1000000" })
        public int size;

        @Override
        public int getSize() {
            return size;
        }

    }

    @State(Scope.Thread)
    public static class SingleInput extends InputWithIncrementingInteger {

        @Param({ "1" })
        public int size;

        @Override
        public int getSize() {
            return size;
        }

    }

    @Benchmark
    public int benchSingle(final SingleInput input) {
        return input.observable.toBlocking().single();
    }

    @Benchmark
    public int benchFirst(final MultiInput input) {
        return input.observable.toBlocking().first();
    }

    @Benchmark
    public int benchLast(final MultiInput input) {
        return input.observable.toBlocking().last();
    }

}
