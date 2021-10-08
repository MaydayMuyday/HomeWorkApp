package lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class ChangeArray {
    public static void main(String[] args) {
        Integer arr1[] = {1, 2};

        change(arr1,0,1);
        System.out.println(arrayToList(arr1));
    }

    static void change(Object[] array, int x, int y) {
        Object arr = array[x];
        array[x] = array[y];
        array[y] = arr;

    }

    static <T> ArrayList<T> arrayToList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
}
