package com.kernelsoft.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        clazz();
        field();
        method();
        constructor();
    }

    private static void clazz() throws ClassNotFoundException {
        Class<?> util = Class.forName("com.kernelsoft.reflection.Util");

        System.out.println("package name : " + util.getPackageName() + "class name : " + util.getSimpleName());


        Class<?>[] interfaces = util.getInterfaces();


        for (Class c : interfaces) System.out.println(c.getSimpleName());

    }

    private static void field() throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> util = Class.forName("com.kernelsoft.reflection.Util");
        Field[] fields = util.getDeclaredFields();
        Constructor<?> constructor = util.getDeclaredConstructor(int.class);
        Util instance = (Util) constructor.newInstance(24);

        for (Field field : fields) System.out.println(field.getName() + " : " + field.getType());

        Field field = util.getDeclaredField("name");
        Field fieldAge = util.getDeclaredField("age");


        fieldAge.setAccessible(true);
        fieldAge.set(instance, 31);

    }

    private static void method() throws NoSuchMethodException {
        final Class<Util> util = Util.class;

        Method[] methods = util.getMethods();

        for (Method m : methods)
            System.out.println(m.getName() + " : " + m.getReturnType() + " : " + m.getModifiers() + " : " + m.getParameterCount() + " : " + Arrays.toString(m.getParameters()));

        Method getterAgeMethod = util.getDeclaredMethod("getName");
        System.out.println("annotations: " + Arrays.toString(getterAgeMethod.getAnnotations()));


    }

    private static void constructor() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        final Class<Util> util = Util.class;

        Constructor<?> constructor = util.getDeclaredConstructor(int.class);
        Util instance = (Util) constructor.newInstance(12);

        Method getterAgeMethod = util.getDeclaredMethod("getAge");
        System.out.println(getterAgeMethod.invoke(instance));
    }


}
