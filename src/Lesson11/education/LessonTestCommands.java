package Lesson11.education;

interface LessonStudentCommandsAdmin  {
    String EXIT = "0";
    String ADD_LESSON = "1";
    String ADD_STUDENT = "2";
    String PRINT_STUDENTS = "3";
    String PRINT_STUDENTS_BY_LESSON = "4";
    String PRINT_LESSONS = "5";
    String DELETE_LESSON_BY_NAME = "6";
    String DELETE_STUDENT_BY_EMAIL = "7";


    static void printCommandsAdmin() {
        System.out.println("\u001B[34m" + "please input " + EXIT + " to EXIT");
        System.out.println("please input " + ADD_LESSON + " for add lesson");
        System.out.println("please input " + ADD_STUDENT + " for add student");
        System.out.println("please input " + PRINT_STUDENTS + " for print student");
        System.out.println("please input " + PRINT_STUDENTS_BY_LESSON + " for print students by lesson");
        System.out.println("please input " + PRINT_LESSONS + " for print lesson");
       System.out.println("please input " + DELETE_LESSON_BY_NAME + " for delete lesson by name");
       System.out.println("please input " + DELETE_STUDENT_BY_EMAIL + " for delete student  by email");

    }

    static void printCommandsUser() {
        System.out.println("\u001B[34m" + "please input " + EXIT + " to EXIT");
        System.out.println("please input " + ADD_LESSON + " for add lesson");
        System.out.println("please input " + ADD_STUDENT + " for add student");
        System.out.println("please input " + PRINT_STUDENTS + " for print student");
        System.out.println("please input " + PRINT_STUDENTS_BY_LESSON + " for print students by lesson");
        System.out.println("please input " + PRINT_LESSONS + " for print lesson");

    }

}
