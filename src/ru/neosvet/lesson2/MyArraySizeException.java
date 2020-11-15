package ru.neosvet.lesson2;

public class MyArraySizeException extends Exception {
    public MyArraySizeException() {
        super("Массив неверного размера.");
    }
}
