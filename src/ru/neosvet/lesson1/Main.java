package ru.neosvet.lesson1;

public class Main {
    public static void main(String[] args) {
        Entity[] entities = new Entity[] {
                new Human(), new Cat(), new Robot()
        };
        for (Entity entity : entities) {
            entity.run();
            entity.jump();
        }
    }
}
