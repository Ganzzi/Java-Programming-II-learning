package D02_package;

import java.util.Arrays;

public class EX05_Arrays {

    public static void main(String[] args) {
        Integer[] arr = {1, 3, 4, 2, 6, 7};

        for (Integer a : arr) {
            System.out.print(a + " ");
        }
        System.out.println("Sorting...");

//      Comparator
        Arrays.sort(arr, (a, b) -> a - b); // increase

        for (Integer a : arr) {
            System.out.print(a + " ");
        }
    }
}
