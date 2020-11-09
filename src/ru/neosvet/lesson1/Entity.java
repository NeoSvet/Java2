package ru.neosvet.lesson1;

public class Entity {
    protected String type;
    protected int limit_distance;
    protected int limit_height;
    protected boolean lose = false;

    public Entity(String type, int limit_distance, int limit_height) {
        this.type = type;
        this.limit_distance = limit_distance;
        this.limit_height = limit_height;
    }

    public Entity(String type) {
        this.type = type;
    }

    public void run() {
        System.out.println(type + " пробежал.");
    }

    public void jump() {
        System.out.println(type + " перепрыгнул.");
    }

    public boolean canRun(int distance) {
        return distance <= limit_distance;
    }

    public boolean canJump(int height) {
        return height <= limit_height;
    }

    public String getType() {
        return type;
    }

    public void setLose(boolean lose) {
        this.lose = lose;
    }

    public boolean isLose() {
        return lose;
    }
}
