package ru.neosvet.lesson1.exercises;

import ru.neosvet.lesson1.interfaces.Entity;
import ru.neosvet.lesson1.interfaces.Exercise;

public class Wall implements Exercise {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void train(Entity entity) {
        if(entity.canJump(height)) {
            entity.jump();
        } else {
            System.out.println(entity.getType() + " не справился.");
            entity.setLose(true);
        }
    }

    @Override
    public String toString() {
        return "Стена высотой " + height;
    }
}
