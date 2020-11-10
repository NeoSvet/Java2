package ru.neosvet.lesson1;

public interface Entity {
    void run();

    void jump();

    boolean canRun(int distance);

    boolean canJump(int height);

    String getType();

    void setLose(boolean lose);

    boolean isLose();
}
