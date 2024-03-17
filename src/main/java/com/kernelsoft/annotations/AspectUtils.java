package com.kernelsoft.annotations;

import java.lang.reflect.Proxy;

public class AspectUtils {
    public static <T> T createProxy(T target, Class<?> commonInterface) {
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                new Class<?>[]{commonInterface},
        new LogHandler(new Util())
        );
    }
}
