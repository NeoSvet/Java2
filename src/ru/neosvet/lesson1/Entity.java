package ru.neosvet.lesson1;

public interface Entity extends Runner, Jumper {
    String getType();

    void setLose(boolean lose);

    boolean isLose();
}
