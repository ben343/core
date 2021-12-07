package Lesson11.education;


import Lesson11.education.model.Lesson;
import Lesson11.education.model.Student;
import Lesson11.education.model.User;
import Lesson11.education.storage.LessonStorage;
import Lesson11.education.storage.StudentStorage;
import Lesson11.education.storage.UserStorage;
import Lesson11.education.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class LessonStudentTest implements LessonStudentCommandsAdmin, Commands {
    static Scanner scanner = new Scanner(System.in);
    static LessonStorage lessonStorage = new LessonStorage();
    static StudentStorage studentStorage = new StudentStorage();
    static UserStorage userStorage = new UserStorage();

    public static void main(String[] args) throws ParseException {
        boolean isRun = true;
        while (isRun) {
            Commands.printCommands();
            String command1 = scanner.nextLine();
            switch (command1) {
                case Commands.EXIT:
                    isRun = false;
                    break;
                case LOGIN:
                    login();
                    break;
                case REGISTER:
                    register();
                    break;
                default:
                    System.out.println("Invalid Command");
            }
        }
    }


    public static void Admin() throws ParseException {
        boolean isRun = true;
        while (isRun) {
            LessonStudentCommandsAdmin.printCommandsAdmin();
            String command = scanner.nextLine();
            switch (command) {
                case LessonStudentCommandsAdmin.EXIT:
                    isRun = false;
                    break;
                case ADD_LESSON:
                    addLesson();
                    break;
                case ADD_STUDENT:
                    addStudent();
                    break;
                case PRINT_STUDENTS:
                    studentStorage.print();
                    break;
                case PRINT_LESSONS:
                    lessonStorage.print();
                    break;
                case PRINT_STUDENTS_BY_LESSON:
                    printStudentByLesson();
                    break;
                case DELETE_LESSON_BY_NAME:
                    deleteLessonByName();
                    break;
                case DELETE_STUDENT_BY_EMAIL:
                    deleteStudentByEmail();
                    break;
                default:
                    System.out.println("invalid command");
            }
        }
    }


    public static void ofUser() throws ParseException {
        boolean isRun = true;
        while (isRun) {
            LessonStudentCommandsAdmin.printCommandsUser();
            String command = scanner.nextLine();
            switch (command) {
                case LessonStudentCommandsAdmin.EXIT:
                    isRun = false;
                    break;
                case ADD_LESSON:
                    addLesson();
                    break;
                case ADD_STUDENT:
                    addStudent();
                    break;
                case PRINT_STUDENTS:
                    studentStorage.print();
                    break;
                case PRINT_LESSONS:
                    lessonStorage.print();
                    break;
                case PRINT_STUDENTS_BY_LESSON:
                    printStudentByLesson();
                    break;
                default:
                    System.out.println("invalid command");
            }
        }
    }


    private static void register() throws ParseException {
        System.out.println("\u001B[35m" + "please input  student's name");
        String name = scanner.nextLine();
        System.out.println("please input student's surname");
        String surname = scanner.nextLine();
        System.out.println("please input student's email");
        String email = scanner.nextLine();
        System.out.println("please input student's password");
        String password = scanner.nextLine();
        System.out.println("please input student's type");
        String type = scanner.nextLine();
        User user = new User(name, surname, email, password, type);
        userStorage.add(user);
        System.out.println("Thank you, user was added");
        if (type.contains("user")) {
            LessonStudentTest.ofUser();
        } else {
            LessonStudentTest.Admin();
        }

    }

    private static void login() throws ParseException {
        System.out.println("\u001B[35m" + "Please input email");
        String email = scanner.nextLine();
        userStorage.getByEmail(email);
        System.out.println("\u001B[35m" + "Please input password");
        String password = scanner.nextLine();
        userStorage.getByPassword(password);
        if (userStorage.getByEmail(email) != null && userStorage.getByPassword(password) != null) {
            User user = userStorage.getByEmail(email);
            if (user != null) {
                if (user.getType().equals("user")) {
                    LessonStudentTest.ofUser();
                } else if (user.getType().equals("admin")) {
                    LessonStudentTest.Admin();
                }
            }
        } else System.out.println("\u001B[37m" + " The user from this email and password dont exist");
    }


    private static void deleteStudentByEmail() {
        System.out.println("\u001B[35m" + "please input student's email");
        String email = scanner.nextLine();
        Student student = studentStorage.getByEmail(email);
        if (student != null) {
            studentStorage.deleteStudentByEmail(student);
        } else {
            System.err.println("Student does not exist");

        }


    }

    private static void deleteLessonByName() {
        System.out.println("\u001B[35m" + "please input the name of the lesson");
        String name = scanner.nextLine();
        Lesson lesson = lessonStorage.getByName(name);
        if (lesson != null) {
            lessonStorage.deleteLessonByName(name);
        } else {
            System.err.println("Lesson does not exist");

        }
        LessonStudentCommandsAdmin.printCommandsAdmin();
    }

    private static void printStudentByLesson() {
        System.out.println("\u001B[35m" + "please input the name of the lesson");
        String name = scanner.nextLine();
        Lesson lesson = lessonStorage.getByName(name);
        if (lesson != null) {
            studentStorage.printStudentByLesson(name);

        } else {
            System.out.println("Student does not exist");

        }
    }

    private static void addStudent() throws ParseException {
        System.out.println("\u001B[35m" + "please input  students name");
        String name = scanner.nextLine();
        System.out.println("please input students surname");
        String surname = scanner.nextLine();
        System.out.println("please input students age");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("please input students email");
        String email = scanner.nextLine();
        System.out.println("please input students phone");
        int phone = Integer.parseInt(scanner.nextLine());
        System.out.println("please input dateOfBirth");
        String dateOfBirth = scanner.nextLine();
        Date date = DateUtil.stringToDate(dateOfBirth);
        System.out.println("please input lessons name" + "\u001B[35m");
        String lessonName = scanner.nextLine();
        String[] lessonNames = lessonName.split(",");

        int size = 0;
        for (int i = 0; i < lessonNames.length; i++) {
            if (lessonStorage.getByName(lessonNames[i]) != null)
                size++;
        }
        Lesson[] lesson = new Lesson[size];
        for (int i = 0; i < lessonNames.length; i++) {
            if (lessonStorage.getByName(lessonNames[i]) != null) {
                lesson[i] = lessonStorage.getByName(lessonNames[i]);
            }
        }
        Student student = new Student(name, surname, age, email, phone, date, lesson);
        studentStorage.add(student);
        System.out.println("Thank you, Student was added");

    }

    private static void addLesson() {
        System.out.println("\u001B[35m" + "please input lesson name,duration,lecturerName,price,");
        String lessonDataStr = scanner.nextLine();
        String[] lessonData = lessonDataStr.split(",");
        if (lessonData.length == 4) {
            Lesson lesson = new Lesson(lessonData[0], Integer.parseInt(lessonData[1]), lessonData[2], Integer.parseInt(lessonData[3]));
            if (lessonStorage.getByName(lesson.getName()) != null) {
                System.out.println("invalid name ");
            } else {
                lessonStorage.add(lesson);
                System.out.println("Thank you lesson is added");
            }

        } else {
            System.out.println("invalid data");

        }
    }
}
