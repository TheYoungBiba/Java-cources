package edu.project5;

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Thread)
public class MethodBenchmark {

    public static final int ITERATIONS = 10000;

//    public static void main(String[] args) throws Exception {
//        org.openjdk.jmh.Main.main(args);
//    }

//    @State(Scope.Benchmark)
//    public static class BenchmarkState {
        Student student = new Student("Alexander", "Biryukov");
        Method directMethod;
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle methodHandle;
        MethodHandle setterHandle;

        @Setup
        public void setup() throws Throwable {
            directMethod = Student.class.getMethod("name");
            methodHandle = lookup.findVirtual(Student.class, "name", MethodType.methodType(String.class));
            setterHandle = lookup.findSetter(Student.class, "name", String.class);
        }
//    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testDirectAccess(BenchmarkState state, Blackhole blackhole) throws Exception {
        for (int i = 0; i < ITERATIONS; i++) {
            blackhole.consume(state.student.name());
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testReflectiveAccess(BenchmarkState state, Blackhole blackhole) throws Throwable {
        for (int i = 0; i < ITERATIONS; i++) {
            blackhole.consume(state.directMethod.invoke(state.student));
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testMethodHandles(BenchmarkState state, Blackhole blackhole) throws Throwable {
        for (int i = 0; i < ITERATIONS; i++) {
            blackhole.consume((String) state.methodHandle.invoke(state.student));
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testLambdaMetafactory(BenchmarkState state, Blackhole blackhole) throws Throwable {
        CallSite site = LambdaMetafactory.metafactory(
            state.lookup,
            "invoke",
            MethodType.methodType(Runnable.class),
            MethodType.methodType(String.class, Student.class),
            state.methodHandle,
            MethodType.methodType(String.class, Student.class)
        );
        for (int i = 0; i < ITERATIONS; i++) {
            blackhole.consume((String) site.getTarget().invokeExact(state.student));
        }
    }
}
