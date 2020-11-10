package ru.neosvet.lesson1;

public class Cat implements Entity {
    private final int LIMIT_DISTANCE = 100;
    private final int LIMIT_HEIGHT = 4;
    private boolean lose = false;

    @Override
    public void run() {
        System.out.println("Кот пробежал.");
    }

    @Override
    public void jump() {
        System.out.println("Кот перепрыгнул.");
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
        return "Кот";
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
