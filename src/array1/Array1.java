package array1;

public class Array1 {

    void Variable(char[] charArray) {

        char Variable = charArray[0];
        char c = 'o';
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'o') {
                System.out.print(c);
            }
        }

    }
}