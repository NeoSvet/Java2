package ru.neosvet.lesson2;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int x, int y) {
        super("В ячейке " + x + "x" + y + " данные неверного типа.");
    }
}
