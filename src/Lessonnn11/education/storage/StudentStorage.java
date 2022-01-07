package Lessonnn11.education.storage;

import Lessonnn11.education.model.Student;
import Lessonnn11.education.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class StudentStorage {


    private List<Student> students = new ArrayList<>();



    public void add(Student student) {
       students.add(student);
       FileUtil.serializeStudents(students);
    }

    public void print() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
    public Student getByEmail(String email) {
        for (Student student : students) {
            if (student.getEmail().equals(email)) {
                return student;
            }
        }return null;

    }
        public void deleteStudentByEmail (String email){
            for (Student student : students) {
                if (student.getEmail().equals(email)) ;
                students.remove(student);
                FileUtil.serializeStudents(students);
            }

        }
        public void printStudentByLesson(String name) {
            for (Student student : students) {
                if (student.getLessons().equals(student)) {
                    System.out.println(student);

                }

            }
        }
    public void initData() {
        List<Student> studentList= FileUtil.deserializeStudents();
        if (studentList!=null){
            students=studentList;

        }
    }
        }







