package ru.neosvet.lesson1;

public class Human implements Entity {
    private final int LIMIT_DISTANCE = 2000;
    private final int LIMIT_HEIGHT = 2;
    private boolean lose = false;

    public void run() {
        System.out.println("Человек пробежал.");
    }

    public void jump() {
        System.out.println("Человек перепрыгнул.");
    }

    public boolean canRun(int distance) {
        return distance <= LIMIT_DISTANCE;
    }

    public boolean canJump(int height) {
        return height <= LIMIT_HEIGHT;
    }

    public String getType() {
        return "Человек";
    }

    public void setLose(boolean lose) {
        this.lose = lose;
    }

    public boolean isLose() {
        return lose;
    }
}
