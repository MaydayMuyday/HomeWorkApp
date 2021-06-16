public class HomeWorkApp {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();


    }

    public static void printThreeWords() {
        System.out.println("_Orange");
        System.out.println("_Banana");
        System.out.println("_Apple");
    }

    public static void checkSumSign() {
        int a;
        int b;
        int c;
        a = 11;
        b = 21;
        c = a + b;
        if (a >= 0) {
            System.out.println("сумма положительная");
        } else {
            System.out.println("сумма отрицательная");
        }
    }

    public static void printColor() {
        int value;
        value = 95;
        if (value <= 0)
        {
            System.out.println(" red");

        }
        if (value <= 100) {
            System.out.println(" yellow");




        } else {
            System.out.println(" green");
        }
    }

    public static void compareNumbers() {
        int a = 4;
        int b = 5;
        if (a >= b) {
            System.out.println(" a >= b");
        } else {
            System.out.println("a < b");
        }



    }
}
