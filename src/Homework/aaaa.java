package Homework;

public class aaaa {
    public static void main(String[] args) {
        for (int i = 0; i <7 ; i++) {
            for (int j = 7; j >i ; j--) {
                System.out.print("  ");
            }
            for (int j = 0; j <=i ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        int a=19;
        int b=20;
        int c= a>b ? 10 : 20;
        System.out.println(c);


    }
}
