package ru.neosvet.lesson3;

import java.util.ArrayList;

public class Phonebook {
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> phones = new ArrayList<>();

    public void add(String name, String phone) {
        names.add(name);
        phones.add(phone);
    }

    public String get(String name) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equals(name))
                result.append(phones.get(i) + "\n");
        }
        if (result.length() == 0)
            return "No found\n";
        return result.toString();
    }
}
