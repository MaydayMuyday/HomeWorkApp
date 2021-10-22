package lesson5;


import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;


public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private static CyclicBarrier sb;
    private static CountDownLatch cdlf;
    private static CountDownLatch cdlr;
    private static boolean win;


    static {
        cdlf = MainClass.CDLF;
        cdlr = MainClass.CDLR;
        sb = MainClass.SB;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            cdlr.countDown();
            System.out.println(this.name + " готов");
            sb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        final ArrayList<Stage> stages = race.getStages();
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);

        }
        checkWinner(this);
        cdlf.countDown();


    }


    private void checkWinner(Car car) {
        if (!win) {
            System.out.println(car.getName() + " ПОБЕДИТЕЛЬ!!!");
            win = true;

            }

        }


    }

