package Homework;

public class Array1 {
    public static void main(String[] args) {
        char[] text = {' ', ' ', 'b', 'a', 'r', ' ', 'e', 'v', ' ', ' '};
        char[] result = new char[text.length];
        int index = 0;
        int i;
        for (i = 0; i < text.length; i++) {
            if (text[i] == ' ') {
                continue;
            }
            if (text[i] != ' ') {
                index++;
                result[index] = text[i];
                break;
            }
        }
        for (int j = i; j < text.length; j++) {
            if (text[j] == ' ') {
                index++;
                result[index] = text[j];
            }
            if (text[j] != ' ') {
                index++;
                result[index] = text[j];
            }
            System.out.print(result[index]);
        }
    }
}