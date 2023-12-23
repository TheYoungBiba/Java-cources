package edu.hw11;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;

public class Task1 {

    @Test
    void creationOfNewClassWithBytes() throws Throwable {
        final String helloByteBuddyMessage = "Hello, ByteBuddy!";
        Class<?> task1 = new ByteBuddy()
            .subclass(Object.class)
            .method(ElementMatchers.named("toString"))
            .intercept(FixedValue.value(helloByteBuddyMessage))
            .make()
            .load(getClass().getClassLoader())
            .getLoaded();
        Constructor<?> task1Constructor = task1.getConstructor();
        final String referent = "Hello, ByteBuddy!";
        String testResult = task1Constructor.newInstance().toString();
        Assertions.assertEquals(referent, testResult);
    }
}
