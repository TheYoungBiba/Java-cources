package edu.hw11;

import edu.hw11.task2.ArithmeticalUnitsInterceptor;
import edu.hw11.task2.ArithmeticalUtils;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task2 {
    @Test
    void behaviorMetamorphosesOfMethodDuringRun() throws Exception {
        Class<? extends ArithmeticalUtils> metamorphose = new ByteBuddy()
            .subclass(ArithmeticalUtils.class)
            .method(ElementMatchers.named("summa"))
            .intercept(MethodDelegation.to(new ArithmeticalUnitsInterceptor()))
            .make()
            .load(getClass().getClassLoader())
            .getLoaded();
        ArithmeticalUtils instance = metamorphose.getConstructor().newInstance();
        final int referent = 116;
        int testResult = instance.summa(29, 4);
        Assertions.assertEquals(referent, testResult);
    }
}
