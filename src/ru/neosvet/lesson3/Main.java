package ru.neosvet.lesson3;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task2() {
        System.out.println("\nTask 2:");

        String[] names = new String[]{
                "Brown", "Red", "White",
                "Smith", "Brown", "Black",
                "Red", "Dark", "White"
        };
        String[] phones = new String[]{
                "+1-111-111-11-11", "+2-222-222-22-22", "+3-333-333-33-33",
                "+4-444-444-44-44", "+5-555-555-55-55", "+6-666-666-66-66",
                "+7-777-777-77-77", "+8-888-888-88-88", "+9-999-999-99-99"
        };

        Phonebook book = new Phonebook();
        for (int i = 0; i < names.length; i++) {
            book.add(names[i], phones[i]);
        }

        System.out.print(book.getListPhones(names[2]));
        System.out.print(book.getListPhones(names[3]));
        System.out.print(book.getListPhones("Jonh"));
    }

    private static void task1() {
        System.out.println("Task 1:");

        String[] words = new String[]{
                "apple", "orange", "pineapple", "mango",
                "cherry", "currant", "raspberry",
                "apple", "orange", "banana", "melon",
                "watermelon", "pineapple", "apple"
        };

        HashMap<String, Integer> hash = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (hash.containsKey(words[i]))
                hash.replace(words[i], hash.get(words[i]) + 1);
            else
                hash.put(words[i], 1);
        }

        System.out.println("Array length: " + words.length);
        System.out.println("Word count: " + hash.size());
        for (Map.Entry<String, Integer> item : hash.entrySet()) {
            System.out.println(item.getKey() + ": " + item.getValue());
        }
    }
}
