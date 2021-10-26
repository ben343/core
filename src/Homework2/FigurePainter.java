package Homework2;

public class FigurePainter {

    void FigureOne(int count, char z) {
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(z + " ");
            }
            System.out.println();
        }
    }

    void FigureTwo(int count, char d) {
        for (int i = 0; i < count; i++) {
            for (int j = count; j > i; j--) {
                System.out.print("  ");

            }
            for (int j = 0; j <= i; j++) {
                System.out.print(d + " ");
            }
            System.out.println();

        }

    }


}






