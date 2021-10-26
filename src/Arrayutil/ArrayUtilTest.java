package Arrayutil;

public class ArrayUtilTest {
    public static void main(String[] args) {
//Elements
        Arrayutil au = new Arrayutil();
        int[] numbers = {5, 7, 98, 7, 65, 4, 3};
        au.ArrayUtil(numbers);
        System.out.println();
        int[] numbers1 = {5, 0, 65, 98, 3, 95};
        au.ArrayUtil(numbers1);
        System.out.println();
// evennumbers
        Arrayutil au1 = new Arrayutil();
        int[] numbers2 = {3, 76, 2, 33, 24, 88, 48, 5, 13, 20, 32, 60};
        int evennumers = au1.evennumbers(numbers2);
        int[] numbers3 = {54, 89, 10, 2, 1, 7, 30};
        int evennumbers2 = au1.evennumbers(numbers3);
        System.out.println("even numbers=" + evennumers);
        System.out.println("even numbers=" + evennumbers2);
//oddnumers
        Arrayutil au3 = new Arrayutil();
        int[] numbers4 = {3, 76, 2, 33, 24, 88, 48, 5, 13, 20, 32, 60};
        int oddnumbers = au3.oddnumbers(numbers4);
        System.out.println("oddnumbers=" + oddnumbers);
        int[] numbers5 = {54, 89, 10, 2, 1, 7, 30, 15, 19};
        int oddnumbers2 = au3.oddnumbers(numbers5);
        System.out.println("oddnumbers=" + oddnumbers2);
//Մասիվի էլեմենտների գումարը
        Arrayutil au4 = new Arrayutil();
        int[] numbers6 = {3, 76, 2, 33, 24, 88, 48, 5, 13, 20, 32, 60};
        int value = au4.value(numbers6);
        System.out.println("value=" + value);
//Մասիվի ամենամեծ և ամենափոքր թվերը
        Arrayutil au5 = new Arrayutil();
        int[] numbers7 = {3, 76, 2, 33, 24, 87, 48, 5, 13, 20, 32, 60};
        int min = au5.min(numbers7);
        System.out.println("min=" + min);
        int max = au5.max(numbers7);
        System.out.println("max=" + max);
        int[] numbers8 = {88, 56, 2, 34, 43, 13, 21, 65, 43, 27, 85};
        int max1 = au5.max(numbers8);
        System.out.println("max1=" + max1);
        if (max > max1) {
            System.out.println("Ամենամեծ էլեմենտը առաջին մասիվի մեջ է։");
        } else {
            System.out.println("Ամենամեծ էլեմենտը երկրորդ մասիվի մեջ է։");
        }
    }
}