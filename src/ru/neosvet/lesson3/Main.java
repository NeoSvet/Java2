package ru.neosvet.lesson3;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        task1();
    }

    private static void task1() {
        System.out.println("Task 1:");

        String[] words = new String[] {
                "apple", "orange", "pineapple", "mango",
                "cherry", "currant", "raspberry",
                "apple", "orange", "pineapple", "mango",
                "cherry", "currant", "raspberry"
        };

        HashSet<String> hash = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            hash.add(words[i]);
        }

        System.out.println("Array length: " + words.length);
        System.out.println("Word count: " + hash.size());
    }
}
