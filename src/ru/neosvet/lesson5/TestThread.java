package ru.neosvet.lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestThread {
    private static final int SIZE = 10000000;
    private float[] arr = new float[SIZE];
    private int thread_stopped = 0, thread_max;
    private long start_time;
    private int total_time, length_part;
    private List<float[]> arrList = new ArrayList<>();
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
        arrList.clear();
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
            System.out.print("OneThread is started... ");
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

    public void multiThread(int k) {
        thread_stopped = 0;
        Arrays.fill(arr, 1f);
        System.out.print(k + " threads is started... ");
        start_time = System.currentTimeMillis();
        thread_max = k;
        length_part = SIZE / k;
        int remainder = SIZE - length_part * k;
        int n = 0;
        for (int i = 0; i < k - 1; i++) {
            startThread(Arrays.copyOfRange(arr, n, n + length_part), n);
            n += length_part;
        }
        startThread(Arrays.copyOfRange(arr, n, n + length_part + remainder), n);
    }

    private void startThread(float[] arr, int offset) {
        Thread thread = new Thread(() -> {
            int n;
            for (int i = 0; i < arr.length; i++) {
                n = i + offset;
                arr[i] = (float) (arr[i] * Math.sin(0.2f + n / 5) *
                        Math.cos(0.2f + n / 5) * Math.cos(0.4f + n / 2));
            }
            arrList.add(arr);
            thread_stopped++;
            if (thread_stopped == thread_max) {
                glueArrs();
                total_time = (int) (System.currentTimeMillis() - start_time);
            }
        });
        thread.start();
        thrList.add(thread);
    }

    private void glueArrs() {
        for (int i = 0; i < arrList.size(); i++) {
            float[] a = arrList.get(i);
            System.arraycopy(a, 0, arr, i * length_part, a.length);
        }
    }
}
