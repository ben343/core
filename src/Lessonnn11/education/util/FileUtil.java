package Lessonnn11.education.util;


import Lessonnn11.education.model.Lesson;
import Lessonnn11.education.model.Student;
import Lessonnn11.education.model.User;


import java.io.*;
import java.util.List;
import java.util.Map;

public class FileUtil {
    private static final String DATA_Phat = "C:\\Users\\Admin\\IdeaProjects\\untitled3\\src\\Lessonnn11\\education\\Data";

    public static void serializeLessons(List<Lesson> lessonList) {

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_Phat + "\\"+"lessons.dat"))) {
            out.writeObject(lessonList);

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }


    }

    public static void serializeStudents(List<Student> studentList) {

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_Phat + "\\"+"students.dat"))) {
            out.writeObject(studentList);

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }


    }

    public static void serializeUserMap(Map<String, User> userMap) {

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_Phat + "\\"+"users.dat"))) {
            out.writeObject(userMap);
        } catch (IOException e) {
            e.printStackTrace();

        }


    }

    public static List<Lesson> deserializeLessons() {
        File lessonFile = new File(DATA_Phat + "\\"+"lessons.dat");

        if (!lessonFile.exists()) {
            try {
                lessonFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(lessonFile))) {
                Object obj = in.readObject();
                return (List<Lesson>) obj;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();

            }
        }


        return null;


    }

    public static List<Student> deserializeStudents() {
        File studentFile = new File(DATA_Phat + "\\"+"students.dat");

        if (!studentFile.exists()) {
            try {
                studentFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(studentFile))) {
                Object obj = in.readObject();
                return (List<Student>) obj;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();

            }
        }


        return null;


    }

    public static Map<String, User> deserializeSUserMap() {
        File userFile = new File(DATA_Phat + "\\"+"users.dat");

        if (!userFile.exists()) {
            try {
                userFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(userFile))) {
                Object obj = in.readObject();
                return (Map<String, User>) obj;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();

            }
        }


        return null;


    }
}