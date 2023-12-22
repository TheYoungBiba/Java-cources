package edu.hw10.task1;

import edu.hw10.task1.annotations.Max;
import edu.hw10.task1.annotations.Min;
import edu.hw10.task1.annotations.NotNull;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ObjectGenerator {
    private static final Logger LOGGER = LogManager.getLogger();

    public ObjectGenerator() {}

    public Object nextObject(Class<?> generatingClass, String fabricMethodName) {
        try {
            Class<?> cls = Class.forName(generatingClass.getName());
            Method creationMethod = getFabricMethod(generatingClass, fabricMethodName);
            if (creationMethod.getParameterCount() == 0) {
                return creationMethod.invoke(cls);
            }
            return creationMethod.invoke(cls, generateInitArgs(creationMethod.getParameters()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Object nextObject(Class<?> generatingClass) {
        try {
            Class<?> cls = Class.forName(generatingClass.getName());
            Constructor<?>[] constructors = new Constructor[cls.getConstructors().length];
            Arrays.stream(cls.getConstructors())
                .sorted(new Comparator<Constructor<?>>() {
                    @Override
                    public int compare(Constructor<?> o1, Constructor<?> o2) {
                        return Integer.compare(o1.getParameterCount(), o2.getParameterCount());
                    }
                })
                .toList()
                .toArray(constructors);
            if (constructors[0] == null) {
                throw new NoSuchMethodException("There is no constructor without parameters");
            }
            if (constructors[0].getParameterCount() == 0) {
                return constructors[0].newInstance();
            } else {
                return constructors[0].newInstance(generateInitArgs(constructors[0].getParameters()));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Method getFabricMethod(Class<?> generatingClass, String methodName) throws NoSuchMethodException {
        for (Method method : generatingClass.getMethods()) {
            if (method.getName().equals(methodName)) {
                return method;
            }
        }
        throw new NoSuchMethodException();
    }

    private Object[] generateInitArgs(Parameter[] parameters) {
        Object[] initArgs = new Object[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            Annotation[] annotations = parameters[i].getAnnotations();
            if (parameters[i].getType().equals(String.class)) {
                if (isNotNull(annotations)) {
                    initArgs[i] = parameters[i].getName();
                }
            } else if (parameters[i].getType().equals(int.class)) {
                initArgs[i] = initInteger(annotations);
            }
        }
        return initArgs;
    }

    public boolean isNotNull(Annotation[] annotations) {
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(NotNull.class)) {
                return true;
            }
        }
        return false;
    }

    private int findAnnotation(Annotation[] annotations, Class<?> annotationClass) {
        for (int i = 0; i < annotations.length; i++) {
            if (annotations[i].annotationType().equals(annotationClass)) {
                return i;
            }
        }
        return -1;
    }

    private int initInteger(Annotation[] annotations) {
        int minAnnotationIndex = findAnnotation(annotations, Min.class);
        int maxAnnotationIndex = findAnnotation(annotations, Max.class);
        Random random = new Random();
        if (minAnnotationIndex != -1 && maxAnnotationIndex == -1) {
            int min = ((Min) annotations[minAnnotationIndex]).value();
            return random.nextInt() + min;
        }
        if (minAnnotationIndex == -1 && maxAnnotationIndex != -1) {
            int max = ((Max) annotations[maxAnnotationIndex]).value();
            return random.nextInt(max);
        }
        if (minAnnotationIndex != -1 && maxAnnotationIndex != -1) {
            int min = ((Min) annotations[minAnnotationIndex]).value();
            int max = ((Max) annotations[maxAnnotationIndex]).value();
            return random.nextInt(min, max);
        }
        return 0;
    }
}
