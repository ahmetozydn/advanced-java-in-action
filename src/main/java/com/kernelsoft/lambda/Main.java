package com.kernelsoft.lambda;

import java.util.*;
import java.util.concurrent.Flow;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String str = "calculate the lenght of the string";
        length(str);

        str = "calculate unique char count of the string";
        uniqueCharCount(str);

        System.out.println("is 5 is prime: " + numTest(Number::isPrime, 5));
        System.out.println("is 8 is even: " + numTest(Number::isEven, 8));
        System.out.println("is -4 is positive: " + numTest(Number::isPositive, -4));

        Predicate<Integer> isEven = n -> (n % 2) == 0;

        Function<String, Integer> lengthFunction = (string) -> string.length();

        final Runnable zeroParameterLambda = () -> System.out.println("Zero parameter lambda");

        Supplier<String> greetingSupplier = () -> "Hello, World!";

        if (isEven.test(5)) System.out.println("5 is even");
        System.out.println(lengthFunction.apply("give the length"));
        System.out.println(greetingSupplier.get());

        final Consumer<String> stringConsumer = (String name) -> System.out.println("Hello, " + name);

        final Consumer<List<String>> listConsumer = (List<String> list) -> Collections.sort(list, (a, b) -> a.compareTo(b));


        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        numbers.forEach(n -> {
            System.out.print(n);
        });

        List<Integer> filteredeNumbers = numbers.stream().filter(n -> n > 2).collect(Collectors.toList());

        Consumer<Integer> method = (n) -> System.out.println(n);
        numbers.forEach(method);

        Runnable r2 = () -> System.out.println("Thread2 is running...");
        Thread t2 = new Thread(r2);
        t2.start();

        var names = List.of("john", "jonathon");
        names.stream().map(String::toUpperCase).collect(Collectors.toList());


        List<String> countries = List.of("Turkey", "Germany", "Tanzania", "France", "Belgium");

        countries.stream()
                .filter((String p) -> p.startsWith("T"))
                .map(p -> p.toUpperCase())
                .sorted()
                .forEach(System.out::println);

    }

    public static void length(String str) {
        StringUtil lambdaFunction;

        lambdaFunction = (String n) -> n.length();

        int length = lambdaFunction.length(str);

        System.out.println("Length of the string : " + length);

    }

    public static void uniqueCharCount(String str) {

        StringUtil lambdaFunction = n -> {
            Set<Character> uniqueChars = new HashSet<>();

            for (char ch : n.toCharArray()) uniqueChars.add(ch);

            return uniqueChars.size();
        };

        int length = lambdaFunction.length(str);

        System.out.println("Unique Char Count : " + length);
    }

    static boolean numTest(NumberUtil n, int v) {
        return n.functionTemplate(v);
    }


}
