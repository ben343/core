package Lesson9.homework;

public class PracticeHomework {
    //փոխակերպել տրված րոպեն վայրկյանի ու վերադարձնել

    long convert(int minutes) {
        long secound = (long) minutes * 60;
        return secound;
    }

    //ընդունել տարին, վերադարձնել օրերի քանակը։
    int calcAge(int years) {
        int day = years * 365;
        return day;
    }

    //վերադարձնել տրված թվի հաջորդ թիվը
    int number;

    int nextNumber(int number) {
        int nextissue = number + 1;
        return nextissue;
    }

    //վերադարձնել true եթե տրված a և b թվերը իրար հավասար են, եթե ոչ՝ false

    boolean isSameNum(int a, int b) {
        boolean c = false;
        if (a == b) {
            c = true;

        }
        return c;


    }

    //վերադարձնել true-եթե թիվը փոքր կամ հավասար է 0-ին։
    //մնացած դեպքերում վերադարձնել false
    boolean lessThanOrEqualToZero(int number) {
        boolean d = false;
        if (number <= 0) {
            d = true;

        }
        return d;
    }


    //վերադարձնել երկու մասիվի ամենամեծ length-ը
    int maxLength(int[] array1, int[] array2) {
        int maxlenght = array2.length;
        if (array1.length > array2.length) {
            maxlenght = array1.length;
        }
        return maxlenght;

    }

}


