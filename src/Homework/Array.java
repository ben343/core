package Homework;

public class Array {
    public static void main(String[] args) {
        char[] text = {' ', ' ', 'b', 'a', 'r', ' ', 'e', 'v', ' ', ' '};
        char[] resul = new char[text.length];
        int index =0;
        int i;
        for (i = 0; i < text.length; i++) {
            if (text[i] == ' ') {
            }
            if (text[i] != ' ') {
                index++;
                resul[index] = text[i];
                break;
            }
        }
        for (int j = i; j < text.length; j++) {
            if (text[j] == ' ') {
                index++;
                resul[index] = text[j];
            }
            if (text[j] != ' ') {
                index++;
                resul[index] = text[j];
            }
            System.out.print(resul[index]);
        }
    }
}











