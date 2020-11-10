package ru.neosvet.lesson1;

public class Cat implements Entity {
    private final int LIMIT_DISTANCE = 100;
    private final int LIMIT_HEIGHT = 4;
    private boolean lose = false;

    public void run() {
        System.out.println("Кот пробежал.");
    }

    public void jump() {
        System.out.println("Кот перепрыгнул.");
    }

    public boolean canRun(int distance) {
        return distance <= LIMIT_DISTANCE;
    }

    public boolean canJump(int height) {
        return height <= LIMIT_HEIGHT;
    }

    public String getType() {
        return "Кот";
    }

    public void setLose(boolean lose) {
        this.lose = lose;
    }

    public boolean isLose() {
        return lose;
    }
}
