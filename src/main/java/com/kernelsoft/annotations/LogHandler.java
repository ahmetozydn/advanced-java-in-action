package com.kernelsoft.annotations;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {

    private final Object target;

    public LogHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        LogBeforeAndAfter annotation = method.getAnnotation(LogBeforeAndAfter.class);

        Object result = null;
        if (annotation != null) {
            System.out.println("before execution, intercepted by proxy");
            if (annotation.printClassName()) {
                System.out.println("Class Name: " + target.getClass().getName());
            }
            if (annotation.printMethodName()) {
                System.out.println("Method Name: " + method.getName());
            }

            result = method.invoke(target, args);

            System.out.println("after execution, intercepted by proxy");
            if (annotation.printClassName()) {
                System.out.println("Class Name: " + target.getClass().getName());
            }
            if (annotation.printMethodName()) {
                System.out.println("Method Name: " + method.getName());
            }
        }


        return result;
    }


}