package ru.neosvet.lesson5;

public class Main {
    public static void main(String[] args) {
        TestThread test = new TestThread();
        int t;
        test.oneThread();
        test.waitFinish();
        t = test.getTotalTime();
        System.out.println("Time: " + t);
        System.out.println("Sum: " + test.getSum());

        test.twoThread();
        test.waitFinish();
        t = test.getTotalTime();
        System.out.println("Time: " + t);
        System.out.println("Sum: " + test.getSum());
    }
}
