package Lesson9.homework;

public class PracticeHomeworkTest {
    public static void main(String[] args) {
        PracticeHomework pr = new PracticeHomework();
        long second = pr.convert(1);
        System.out.println(second);

        int day = pr.calcAge(1);
        System.out.println(day);

        int nextissue = pr.nextNumber(89);
        System.out.println(nextissue);


        boolean c = pr.isSameNum(20, 20);
        System.out.println(c);

        boolean d = pr.lessThanOrEqualToZero(-3);
        System.out.println(d);

        int[] array1 = {2, 7, 6, 5};
        int[] array2 = {3, 6, 5, 8, 7, 6, 5, 4};
        System.out.println(pr.maxLength(array1,array2));


    }

}
