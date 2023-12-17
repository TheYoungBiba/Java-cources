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

    @SuppressWarnings("unchecked")
    public static <T> T create(T origin, Class<?> interfaceClass) {
        return (T) Proxy.newProxyInstance(
            interfaceClass.getClassLoader(),
            new Class<?>[] {interfaceClass},
            new CacheProxy(origin)
        );
    }

    public static HashMap<String, Object> getCacheMap() {
        return cacheMap;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Cache cacheAnnotation = method.getAnnotation(Cache.class);
        if (cacheAnnotation != null) {
            Object o;
            String key = method.getName() + "(" + Arrays.deepToString(args) + ")";
            if (cacheAnnotation.persist()) {
                String cacheName = method.getName() + "_" + Arrays.deepToString(args) + ".txt";
                Path cache = Path.of("src", "main", "java", "edu", "hw10", "task2", "cache", cacheName);
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
}
