package com.kernelsoft.collections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main {
    static List<String> cities = Arrays.asList("Istanbul", "Ankara", "Izmır", "Adana", "Bursa", "Konya");

    public static void main(String[] args) {

        arrayList();
        set();
        linkedlist();
        hashMap();
        queue();
        stack();
        stream();
    }

    private static void stream() {
        IntStream intStream = IntStream.range(1, 3);
        intStream.forEach(System.out::println);
        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
        System.out.println(streamIterated.toList().size());

        List<String> extendedList = cities.stream()
                .map(s -> "name" + s)
                .collect(Collectors.toList());

        var filtered = cities.stream().filter(s -> {
            return s.startsWith("A");
        }).toList();

        Optional<String> first = filtered.stream().findFirst();
        Optional<String> anyElement = filtered.stream().findAny();


        Map<String, Integer> nameLengthsMap = cities.stream()
                .collect(Collectors.toMap(name -> name, String::length));


        int maxLength = cities.stream()
                .map(String::length)
                .max(Integer::compareTo)
                .orElse(0);

        System.out.println("max length:" + maxLength);

        Map<Character, List<String>> groupedNames = cities.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0)));

        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );

        boolean anyEven = cities.stream().anyMatch(s -> s == "Istanbul");

        cities.stream()
                .skip(2)
                .limit(2)
                .collect(Collectors.toList());

    }

    private static void stack() {
        Stack<String> stack = new Stack<>();

        stack.push("Java");
        stack.push("is");
        stack.push("fun!");

        String poppedElement = stack.pop();
        String topElement = stack.peek();
        boolean isEmpty = stack.isEmpty();
        int position = stack.search("Java");
    }

    private static void queue() {
        Queue<String> queue = new LinkedList<>();
        queue.offer("Apple");
        queue.offer("Banana");
        queue.offer("Orange");

        String head = queue.peek();
        String removedElement = queue.poll();

    }

    private static void hashMap() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Apple");
        hashMap.put(2, "Banana");
        hashMap.put(3, "Orange");

        String value = hashMap.get(1);
        hashMap.remove(1);

        if (hashMap.containsKey("Orange")) {
            System.out.println("contains!");
        }

        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

    }

    private static void linkedlist() {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Orange");

        linkedList.remove("Apple");
        linkedList.addFirst("Grapes");
        linkedList.addLast("Mango");
        linkedList.removeFirst();

    }

    private static void set() {
        Set<String> cities = Set.of("Istanbul", "Izmir", "Adana");
        cities.forEach(System.out::println);
    }

    private static void arrayList() {
        List<String> cities = List.of("Istanbul", "Izmir", "Adana", "");

        Iterator iterator = cities.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
