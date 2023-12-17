package edu.hw11.task3;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.jar.asm.Opcodes;

public final class FibonacciClassFactory {
    private FibonacciClassFactory() {}

    public static Class<?> create() {
        return new ByteBuddy()
            .subclass(Object.class)
            .name("Fibonacci")
            .defineMethod("fib", long.class, Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC)
            .withParameters(int.class)
            .intercept(new Implementation.Simple(new FibonacciBCAppender()))
            .make()
            .load(
                ClassLoader.getSystemClassLoader(),
                ClassLoadingStrategy.Default.WRAPPER
            )
            .getLoaded();
    }
}
