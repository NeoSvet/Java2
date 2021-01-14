package ru.neosvet.lesson3;

import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook {
    private HashMap<String, ArrayList<String>> people = new HashMap<>();

    public void add(String name, String phone) {
        ArrayList<String> phones;
        if (people.containsKey(name)) {
            phones = people.get(name);
            phones.add(phone);
            people.replace(name, phones);
        } else {
            phones = new ArrayList<>();
            phones.add(phone);
            people.put(name, phones);
        }
    }

    public String getListPhones(String name) {
        StringBuilder result = new StringBuilder("Phones for ");
        result.append(name);
        if (!people.containsKey(name)) {
            result.append(": No found\n");
            return result.toString();
        }
        result.append(":\n");
        for (String phone : people.get(name)) {
            result.append(phone + "\n");
        }
        return result.toString();
    }
}
