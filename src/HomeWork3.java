import java.util.Scanner;

public class HomeWork3 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//        array();
//        fullArray();
//        calcArray();
        fillDiagonal();
//        scannerMass();


    }

    public static void array() {
        int[] arr = {0, 1, 0, 1, 0, 0, 1};

        for (int i = 0; i < arr.length; i++) {
            //  System.out.printf("%3d ", arr[i]);

            arr[i] = (arr[i] > 0) ? 0 : 1;
            System.out.printf("%3d ", arr[i]);

        }

    }

    public static void fullArray() {

        int[] fArr = new int[101];
        for (int i = 1; i < fArr.length; i++) {
            fArr[i] = i;
            System.out.println("arr[" + i + "] = " + fArr[i]);

        }

    }

    public static void calcArray() {
        int[] cArr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] < 6) {
                cArr[i] *= 2;
            }
            System.out.print(cArr[i] + " ");

        }
    }

    public static void fillDiagonal() {
        int[][] arr = new int[5][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0, x = arr[i].length - 1; j < arr[i].length; j++, x--) {
                if (i == j || i == x) arr[i][j] = 1;
                else arr[i][j] = 0;
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void scannerMass() {
        int len;
        int initialValue;
        System.out.println(" Input len number:" + "\n");
        len = sc.nextInt();
        System.out.println(" Input initialValue number:" + "\n");
        initialValue = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
            System.out.print("[" + i + "]" + arr[i] + " ");


        }
    }


}









