package ru.neosvet.lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestThread {
    private static final int SIZE = 10000000;
    private static final int HALF_SIZE = SIZE / 2;
    private static final int THREAD_MAX = 2;
    private float[] arr = new float[SIZE];
    private float[] arr1, arr2;
    private int thread_stopped = 0;
    private long start_time;
    private int total_time;
    private List<Thread> thrList = new ArrayList<>();

    public void waitFinish() {
        try {
            for (int i = 0; i < thrList.size(); i++) {
                thrList.get(i).join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thrList.clear();
    }

    public int getTotalTime() {
        return total_time;
    }

    public float getSum() {
        float sum = 0f;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public void oneThread() {
        Arrays.fill(arr, 1f);
        Thread thread = new Thread(() -> {
            System.out.println("OneThread is started...");
            long start_time = System.currentTimeMillis();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) *
                        Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            total_time = (int) (System.currentTimeMillis() - start_time);
        });
        thread.start();
        thrList.add(thread);
    }

    public void twoThread() {
        Arrays.fill(arr, 1f);
        thread_stopped = 0;
        System.out.println("TwoThread is started...");
        start_time = System.currentTimeMillis();
        arr1 = Arrays.copyOfRange(arr, 0, HALF_SIZE);
        startThread(arr1, 0);
        arr2 = Arrays.copyOfRange(arr, HALF_SIZE, SIZE);
        startThread(arr2, HALF_SIZE);
    }

    private void startThread(float[] arr, int offset) {
        Thread thread = new Thread(() -> {
            int n;
            for (int i = 0; i < arr.length; i++) {
                n = i + offset;
                arr[i] = (float) (arr[i] * Math.sin(0.2f + n / 5) *
                        Math.cos(0.2f + n / 5) * Math.cos(0.4f + n / 2));
            }
            thread_stopped++;
            if (thread_stopped == THREAD_MAX) {
                glueArrs();
                total_time = (int) (System.currentTimeMillis() - start_time);
            }
        });
        thread.start();
        thrList.add(thread);
    }

    private void glueArrs() {
        System.arraycopy(arr1, 0, arr, 0, HALF_SIZE);
        System.arraycopy(arr2, 0, arr, HALF_SIZE, HALF_SIZE);
    }
}
