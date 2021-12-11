package Lesson11.education.model;

import Lesson11.education.util.DateUtil;

import java.util.Arrays;
import java.util.Date;

public class Student {
    private String name;
    private String surname;
    private int age;
    private String email;
    private int phone;
    private Date dateOfBirth;
    private Lesson[] lessons;

    public Student(String name, String surname, int age, String email, int phone, Date dateOfBirth, Lesson[] lessons) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.lessons = lessons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }


    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Lesson[] getLessons() {
        return lessons;
    }

    public void setLessons(Lesson[] lessons) {
        this.lessons = lessons;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", dateOfBirth=" + DateUtil.dateToString(dateOfBirth) +
                ", lessons=" + Arrays.toString(lessons) +
                '}';
    }
}






