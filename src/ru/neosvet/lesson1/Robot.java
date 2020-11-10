package ru.neosvet.lesson1;

public class Robot implements Entity {
    private final int LIMIT_DISTANCE = 4000;
    private final int LIMIT_HEIGHT = 1;
    private boolean lose = false;

    public void run() {
        System.out.println("Робот пробежал.");
    }

    public void jump() {
        System.out.println("Робот перепрыгнул.");
    }

    public boolean canRun(int distance) {
        return distance <= LIMIT_DISTANCE;
    }

    public boolean canJump(int height) {
        return height <= LIMIT_HEIGHT;
    }

    public String getType() {
        return "Робот";
    }

    public void setLose(boolean lose) {
        this.lose = lose;
    }

    public boolean isLose() {
        return lose;
    }
}
