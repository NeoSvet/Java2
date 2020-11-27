package ru.neosvet.lesson5;

import java.util.Arrays;

public class TestThread {
    private static final int SIZE = 10000000;
    private static final int HALF_SIZE = SIZE / 2;
    private static final int THREAD_MAX = 2;
    private static float[] arr = new float[SIZE];
    private int thread_stoped = 0;
    private long start_time;

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

    public void twoThread() {
        Arrays.fill(arr, 1f);
        System.out.println("TwoThread is started...");
        start_time = System.currentTimeMillis();
        startThread(Arrays.copyOfRange(arr, 0, HALF_SIZE), 0);
        startThread(Arrays.copyOfRange(arr, HALF_SIZE, SIZE), HALF_SIZE);
    }

    private void startThread(float[] arr, int offset) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + ((i + offset) / 5)) *
                        Math.cos(0.2f + ((i + offset) / 5)) * Math.cos(0.4f + ((i + offset) / 2)));
            }
            thread_stoped++;
            if (thread_stoped == THREAD_MAX)
                System.out.println("Time for TwoThread: " + (System.currentTimeMillis() - start_time));
        });
        thread.start();
    }
}