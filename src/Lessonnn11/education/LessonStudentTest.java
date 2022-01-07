package Lessonnn11.education;



import Lessonnn11.education.model.Lesson;
import Lessonnn11.education.model.Student;
import Lessonnn11.education.model.UserType;
import Lessonnn11.education.model.User;
import Lessonnn11.education.storage.LessonStorage;
import Lessonnn11.education.storage.StudentStorage;
import Lessonnn11.education.storage.UserStorage;
import Lessonnn11.education.util.DateUtil;

import java.text.ParseException;
import java.util.*;

public class LessonStudentTest implements LessonStudentCommands {
    static Scanner scanner = new Scanner(System.in);
    static LessonStorage lessonStorage = new LessonStorage();
    static StudentStorage studentStorage = new StudentStorage();
    static UserStorage userStorage = new UserStorage();




    public static void main(String[] args) throws ParseException {
initData();

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

    private static void initData() {
        lessonStorage.initData();
        studentStorage.initData();
        userStorage.initData();
    }


    public static void adminLogin() {
        boolean isRun = true;
        while (isRun) {
            LessonStudentCommands.printCommandsAdmin();
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

            userStorage.getByEmail(email);



            System.out.println("Please input name ");
            String name = scanner.nextLine();
            System.out.println("please input student's surname");
            String surname = scanner.nextLine();
            System.out.println("please input student's password");
            String password = scanner.nextLine();
            System.out.println("please input student's type (ADMIN,USER)");
            String type = scanner.nextLine();
            User user = new User();
            user.setEmail(email);
            user.setName(name);
            user.setSurname(surname);
            user.setPassword(password);
            user.setType(UserType.valueOf(type.toUpperCase()));
            userStorage.add(user);
            System.out.println("User was registered!");

        }




    private static void login() {
System.out.println("\u001B[35m" + "please input student's email");
        String email = scanner.nextLine();
        User byEmail = null;

            byEmail = userStorage.getByEmail(email);
            System.out.println("please input student's password");
            String password = scanner.nextLine();

            if (byEmail.getPassword().equals(password)) {
                if (byEmail.getType() == UserType.ADMIN) {
                    adminLogin();
                } else if (byEmail.getType() == UserType.USER) {
                    userLogin();
                }

            } else {
                System.out.println("password is worng!");

            }



        }



    private static void deleteStudentByEmail() {
        System.out.println("\u001B[35m" + "please input student's email");
        String email = scanner.nextLine();
        Student student = studentStorage.getByEmail(email);
        if (student != null) {
            studentStorage.deleteStudentByEmail(email);
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
        List<Lesson> lessons = new LinkedList<>();
        for (Lesson lesson : lessons) {
            if (lessonStorage.getByName(lesson.getName()) != null) {
                lessons.add(lesson);
        }


        }
        Student student = new Student(name, surname, age, email, phone, date, lessons);
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
