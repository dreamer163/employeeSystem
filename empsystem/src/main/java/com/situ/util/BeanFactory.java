package com.situ.util;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class BeanFactory {
    private static final Map<Class<?>, Object> INSTANCES = new HashMap<>();


    public static <T> T getBean(Class<T> clazz) {
        T t = (T) INSTANCES.get(clazz);
        if (t != null) {
            return t;
        }
        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor();
            t = constructor.newInstance();
            INSTANCES.put(clazz, t);
            return t;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
