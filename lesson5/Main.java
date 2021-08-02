package lesson5;

import java.util.Arrays;

class Main {


    private static final int SIZE = 10000000;
    private static final int H = SIZE / 2;
    private static float[] arr = new float[SIZE];

    public static void main(String[] args) {

        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }

        long oneThread = firstMethod(arr);
        long twoThread = secondMethod(arr);


    }

    private static long firstMethod(float[] arr) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long oneThread = System.currentTimeMillis() - start;

        System.out.println("one thread time: " + oneThread + "ms");
        return oneThread;
    }

    private static long secondMethod(float[] arr) {
        float[] a = new float[H];
        float[] b = new float[H];

        long start = System.currentTimeMillis();

        System.arraycopy(arr, 0, a, 0, H);
        System.arraycopy(arr, H, b, 0, H);

        MyThread t1 = new MyThread("a", a);
        MyThread t2 = new MyThread("b", b);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        a = t1.getArr();
        b = t2.getArr();

        System.arraycopy(a, 0, arr, 0, H);
        System.arraycopy(b, 0, arr, H, H);

        long twoThread = System.currentTimeMillis() - start;

        System.out.println("two thread time: " + twoThread + "ms");

        return twoThread;
    }


}

