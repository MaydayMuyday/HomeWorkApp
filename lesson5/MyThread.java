package lesson5;


public class MyThread extends Thread {
    private float[] arr;

    public MyThread(String name, float[] arr) {
        super(name);
        this.arr = arr;
    }


    float[] getArr() {
        return arr;
    }

    @Override
    public void run() {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        }
    }
}
