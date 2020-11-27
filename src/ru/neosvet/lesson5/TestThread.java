package ru.neosvet.lesson5;

import java.util.Arrays;

public class TestThread {
    private static final int size = 10000000;
    private static final int h = size / 2;
    private static float[] arr = new float[size];

    public void oneThread() {
        Arrays.fill(arr, 1f);
        Thread thread = new Thread(() -> {
            System.out.println("OneThread is started...");
            long start_time = System.currentTimeMillis();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("Time for OneThread: " + (System.currentTimeMillis() - start_time));
        });
        thread.start();
    }
}
