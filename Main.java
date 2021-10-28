package lesson6;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }

    public static int[] oneMethod(int[] arr) {


        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) {

                return Arrays.copyOfRange(arr, i + 1, arr.length);
            }
        }
        throw new RuntimeException("4 не найдена");
    }


    public static boolean twoMethod(int[] arr1) {
        boolean one = false;
        boolean four = false;
        for (int i = 0; i < arr1.length; i++) {


            if (arr1[i] != 1 && arr1[i] != 4) {
                return false;
            }

            if (arr1[i] == 1) {
                one = true;
            }
            if
            (arr1[i] == 4) {
                four = true;
            }

        }
        return one && four;
    }
}


