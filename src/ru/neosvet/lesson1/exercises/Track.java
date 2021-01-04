package ru.neosvet.lesson1.exercises;

import ru.neosvet.lesson1.interfaces.Entity;
import ru.neosvet.lesson1.interfaces.Exercise;

public class Track implements Exercise {
    private int distance;

    public Track(int distance) {
        this.distance = distance;
    }

    @Override
    public void train(Entity entity) {
        if(entity.canRun(distance)) {
            entity.run();
        } else {
            System.out.println(entity.getType() + " не справился.");
            entity.setLose(true);
        }
    }

    @Override
    public String toString() {
        return "Дорожка длиной " + distance;
    }
}
