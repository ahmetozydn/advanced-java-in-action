package com.kernelsoft.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        genericClass();
        genericClass2();
        genericMethod(new String[0]);


    }


    private static void genericClass() {

        Gen<String> gen = new Gen<>("Dynamic Value");
        System.out.println(gen.getData());
    }

    private static void genericClass2() {
        Gen2<Double> gen2 = new Gen2<>(4.2);
        System.out.println(gen2.getData());
    }

    public static <T> List<T> genericMethod(T[] a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }
}
