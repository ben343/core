package Homework;

public class ArrayExample {
    public static void main(String[] args) {
        char[] charArray = {'b', 'o', 'b', 'o', 'b', 'a',};
        // Մասիվի աաջին էլեմենտը
        System.out.print(charArray[0] + "-աաջին էլեմենտը,");
        // Վերջին էլեմենտը
        System.out.print(charArray[charArray.length - 1] + "-Վերջին էլեմենտը,");
        //նախավերջին էլեմենտը
        System.out.print(charArray[charArray.length - 2] + "-նախավերջին էլեմենտը,");
        //մեջտեղի էլեմենտը
        System.out.print(charArray[charArray.length / 2] + "-մեջտեղի էլեմենտը,");
        System.out.println();
        //մասիվի ինդեքսները որոնք հավասար են o-ի
        char c = 'o';
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'o') {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        // տպել с փոփոխականի քանակը
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == c) {
                count++;
            }
        }
        System.out.print("count of " + c + " = " + count);
        System.out.println();
        //տպել true եթե մասիվը վերջանում է ly-ով
        boolean b = false;
        if (charArray[charArray.length - 2] == 'l' &&
                charArray[charArray.length - 1] == 'y') {
            b = true;
        }
        System.out.println(b);
        boolean isbob = false;
        for (int i = 0; i < charArray.length - 2; i++) {
            if (charArray[i] == 'b' && charArray[i + 2] == 'b') {
                isbob = true;
                break;

            }
        }
        System.out.println(isbob);
        char[] charArray1 = {' ', ' ', 'h', 'e', 'l', 'l', 'o', ' ', 'j', 'a', 'a', 'v', 'a', ' ', ' '};
        int startIndex = 0;
        int endIndex = charArray1.length - 1;
        while (startIndex < endIndex && charArray1[startIndex] == ' ') {
            startIndex++;
        }
        while (endIndex > startIndex && charArray1[endIndex] == ' ') {
            endIndex--;
        }
        char[] result = new char[(endIndex - startIndex) + 1];
        int index = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            result[index++] = charArray1[i];

        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

        }
        System.out.println();
//գտնել մասիվի կրկնվող էլեմենտները
        int[] array = {3, 5, 34, 5, 21, 3, 17, 6};
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length - 1; j++) {
                if (array[i] == array[j + 1]) {
                    System.out.println(array[i] + "-ը կրկնվում է");
                }
            }
        }
        // տպել true եթե մասիվի բոլոր էլեմենտները զույգ են
        boolean d = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                d = false;
            }
        }
        System.out.println(d);
    }
}