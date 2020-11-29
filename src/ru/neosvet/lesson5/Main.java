package ru.neosvet.lesson5;

public class Main {
    public static void main(String[] args) {
        TestThread test = new TestThread();
        int t1, t2;
        test.oneThread();
        test.waitFinish();
        System.out.println("Sum: " + test.getSum());
        t1 = test.getTotalTime();
        System.out.println("Time: " + t1);

        for (int i = 2; i < 11; i++) {
            test.multiThread(i);
            test.waitFinish();
            System.out.println("Sum: " + test.getSum());
            t2 = test.getTotalTime();
            System.out.printf("Time: %d, faster then previous one by %.1f%%\n", t2, (t1 / (float) t2 * 100f - 100f));
            t1 = t2;
        }
    }
}
