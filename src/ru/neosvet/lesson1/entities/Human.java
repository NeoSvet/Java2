package ru.neosvet.lesson1.entities;

import ru.neosvet.lesson1.interfaces.Entity;

public class Human implements Entity {
    private final int LIMIT_DISTANCE = 2000;
    private final int LIMIT_HEIGHT = 2;
    private boolean lose = false;

    @Override
    public void run() {
        System.out.println("Человек пробежал.");
    }

    @Override
    public void jump() {
        System.out.println("Человек перепрыгнул.");
    }

    @Override
    public boolean canRun(int distance) {
        return distance <= LIMIT_DISTANCE;
    }

    @Override
    public boolean canJump(int height) {
        return height <= LIMIT_HEIGHT;
    }

    @Override
    public String getType() {
        return "Человек";
    }

    @Override
    public void setLose(boolean lose) {
        this.lose = lose;
    }

    @Override
    public boolean isLose() {
        return lose;
    }
}
