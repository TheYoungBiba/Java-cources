package edu.hw10.task2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;

public class CacheProxy implements InvocationHandler {
    private final Object origin;
    private final static HashMap<String, Object> cacheMap = new HashMap<>();

    private CacheProxy(Object origin) {
        this.origin = origin;
    }

    public static HashMap<String, Object> getCacheMap() {
        return cacheMap;
    }

    @SuppressWarnings("unchecked")
    public static <T> T create(T origin, Class<?> interfaceClass) {
        return (T) Proxy.newProxyInstance(
            interfaceClass.getClassLoader(),
            new Class<?>[] {interfaceClass},
            new CacheProxy(origin)
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getAnnotation(Cache.class) != null) {
            Object o;
            String key = getCacheName(method, args);
            if (method.getAnnotation(Cache.class).persist()) {
                Path cache = getCacechingPath(method, args);
                if (Files.exists(cache)) {
                    try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(cache.toFile()))) {
                        o = inputStream.readObject();
                    } catch (IOException e) {
                        throw new RuntimeException();
                    }
                } else {
                    o = method.invoke(origin, args);
                    try (ObjectOutputStream outputStream
                             = new ObjectOutputStream(new FileOutputStream(cache.toFile()))) {
                        outputStream.writeObject(o);
                    } catch (IOException e) {
                        throw new RuntimeException();
                    }
                }
            } else if (cacheMap.containsKey(key)) {
                o = cacheMap.get(key);
            } else {
                o = method.invoke(origin, args);
                cacheMap.put(key, o);
            }
            return o;
        }
        return method.invoke(origin, args);
    }

    private String getCacheName(Method method, Object[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
            .append(method.getName())
            .append("(");
        StringBuilder temp = new StringBuilder(Arrays.deepToString(args));
        temp.deleteCharAt(0);
        temp.deleteCharAt(temp.length() - 1);
        stringBuilder.append(temp);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private Path getCacechingPath(Method method, Object[] args) {
        String name = getCacheName(method, args);
        return Path.of("src", "main", "java", "edu", "hw10", "task2", "cache", name + ".txt");
    }
}
