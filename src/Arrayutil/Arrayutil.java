package Arrayutil;

public class Arrayutil {
    void ArrayUtil(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    int evennumbers(int[] array1) {
        int evennumbers = 0;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] % 2 == 0) {
                evennumbers++;
            }
        }
        return evennumbers;
    }

    int oddnumbers(int[] array) {
        int oddnumbers = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 > 0) {
                oddnumbers++;
            }
        }
        return oddnumbers;
    }

    int value(int[] array) {
        int value = 0;
        for (int i = 0; i < array.length; i++) {
            value = value + array[i];

        }
        return value;
    }

    int min(int[] array) {

        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    int max(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;

    }
}