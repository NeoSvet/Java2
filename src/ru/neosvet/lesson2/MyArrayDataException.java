package ru.neosvet.lesson2;

public class MyArrayDataException extends Exception {
    public MyArrayDataException() {
        super("В массиве данные неверного типа.");
    }
}
