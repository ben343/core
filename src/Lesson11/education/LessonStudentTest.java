package Lesson11.education;


import Lesson11.education.exception.UserNotFoundException;
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

public class LessonStudentTest implements LessonStudentCommands {
    static Scanner scanner = new Scanner(System.in);
    static LessonStorage lessonStorage = new LessonStorage();
    static StudentStorage studentStorage = new StudentStorage();
    static UserStorage userStorage = new UserStorage();

    public static void main(String[] args) throws ParseException {
        boolean isRun = true;
        while (isRun) {
            LessonStudentCommands.printCommands();
            String command1 = scanner.nextLine();
            switch (command1) {
                case EXIT:
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


    public static void adminLogin() {
        boolean isRun = true;
        while (isRun) {
            LessonStudentCommands.printCommandsAdmin();
            String command = scanner.nextLine();
            switch (command) {
                case LessonStudentCommands.EXIT:
                    System.exit(0);
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
                case LOGOUT:
                    isRun = false;
                    break;
                default:
                    System.out.println("invalid command");
            }
        }
    }


    public static void userLogin() {
        boolean isRun = true;
        while (isRun) {
            LessonStudentCommands.printCommandsUser();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    System.exit(0);
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
                case LOGOUT:
                    isRun = false;
                    break;
                default:
                    System.out.println("invalid command");
            }
        }
    }


    private static void register() {
        System.out.println("\u001B[35m" + "please input student's email");
        String email = scanner.nextLine();
        User user = null;
        try {
            user = userStorage.getByEmail(email);
            System.out.println("please input  student's name");
            String name = scanner.nextLine();
            System.out.println("please input student's surname");
            String surname = scanner.nextLine();
            System.out.println("please input student's password");
            String password = scanner.nextLine();
            System.out.println("please input student's type (ADMIN,USER)");
            String type = scanner.nextLine();
            if (type.equalsIgnoreCase("admin")
                    || type.equalsIgnoreCase("user")) {
                User user1 = new User();
                user.setEmail(email);
                user.setName(name);
                user.setSurname(surname);
                user.setPassword(password);
                user.setType(type.toUpperCase());
                userStorage.add(user1);
                System.out.println("User was registered!");

            } else {
                System.out.println("Invalid type");
            }
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }


    }


    private static void login() {
        System.out.println("\u001B[35m" + "please input student's email");
        String email = scanner.nextLine();
        User byEmail = null;
        try {
            byEmail = userStorage.getByEmail(email);
            System.out.println("please input student's password");
            String password = scanner.nextLine();

            if (byEmail.getPassword().equals(password)) {
                if (byEmail.getType().equalsIgnoreCase("ADMIN")) {
                    adminLogin();
                } else if (byEmail.getType().equalsIgnoreCase("USER")) {
                    userLogin();
                }

            } else {
                System.out.println("password is worng!");

            }
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }


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

    private static void addStudent() {
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
        System.out.println("please input dateOfBirth [12/12/2021]");
        String dateOfBirth = scanner.nextLine();
        Date date = null;
        try {
            date = DateUtil.stringToDate(dateOfBirth);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Invalid date format,please respect format [12/12/2021]");
            return;
        }
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
