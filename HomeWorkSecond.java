import java.awt.*;

public class HomeWorkSecond {
    public static void main(String[] args) {
        System.out.println((checkTrue(13, 8)));
        checkPole(-8);
        System.out.println((checkNum(-8)));
        writeText("LoL", 6);
        System.out.println(leapYear(2020));
    }

    public static boolean checkTrue(int a, int b) {
        int c = a + b;
        return c >= 10 && c <= 20;
    }

    public static void checkPole(int a) {
        if (a >= 0) {
            System.out.println(" число положительное ");
        } else {
            System.out.println(" число отрицательное");
        }
    }

    public static boolean checkNum(int a) {
        return a < 0;
    }

    public static void writeText(String str, int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(+i+ "  " + str);
        }
    }

    public static boolean leapYear(int y) {
        if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
