package ru.neosvet.lesson2;

import java.util.Arrays;

public class Main {
    private static final int SIZE = 4;

    public static void main(String[] args) {
        try {
            String[][] array = getCorrectArray(); //or getWrongSizeArray() or getWrongDataArray()
            printArray(array);
            checkSize(array);
            System.out.println("Сумма массива: " + countSumArray(array));
        } catch (MyArraySizeException exSize) {
            exSize.printStackTrace();
        } catch (MyArrayDataException exData) {
            exData.printStackTrace();
        }
    }

    private static int countSumArray(String[][] array) throws MyArrayDataException {
        int x = 0, y = 0;
        try {
            int sum = 0;
            for (y = 0; y < array.length; y++) {
                for (x = 0; x < array[y].length; x++) {
                    sum += Integer.parseInt(array[y][x]);
                }
            }
            return sum;
        } catch (Exception e) {
            throw new MyArrayDataException(x, y);
        }
    }

    private static void checkSize(String[][] array) throws MyArraySizeException {
        if (array.length != SIZE) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != SIZE) {
                throw new MyArraySizeException();
            }
        }
    }

    private static void printArray(String[][] array) {
        System.out.println("Вывод массива:");
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    private static String[][] getCorrectArray() {
        return new String[][]{
                {"2", "5", "77", "34"},
                {"57", "83", "8", "1"},
                {"23", "19", "67", "7"},
                {"29", "50", "3", "49"}
        };
    }

    private static String[][] getWrongSizeArray() {
        return new String[][]{
                {"2", "5", "77", "34", "33"},
                {"57", "83", "8", "1"},
                {"23", "19", "67", "7"},
                {"29", "50", "3", "49"},
                {"29", "50", "3", "49"}
        };
    }

    private static String[][] getWrongDataArray() {
        return new String[][]{
                {"2", "5", "a", "34"},
                {"57", "83", "8", "1"},
                {"23", "b", "67", "7"},
                {"29", "50", "3", "c"}
        };
    }
}
