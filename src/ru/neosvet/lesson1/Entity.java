package ru.neosvet.lesson1;

public class Entity {
    protected String type;

    public Entity(String type) {
        this.type = type;
    }

    public void run() {
        System.out.println(type + " побежал.");
    }

    public void jump() {
        System.out.println(type + " прыгнул.");
    }
}
