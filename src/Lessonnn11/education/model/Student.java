package Lessonnn11.education.model;



import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Student implements Serializable {
    private String name;
    private String surname;
    private int age;
    private String email;
    private int phone;
    private Date dateOfBirth;
    private List<Lesson> lessons;

    public Student() {
    }

    public Student(String name, String surname, int age, String email, int phone,
                   Date dateOfBirth, List<Lesson> lessons) {
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

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && phone == student.phone && Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(email, student.email) && Objects.equals(dateOfBirth, student.dateOfBirth) && Objects.equals(lessons, student.lessons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, email, phone, dateOfBirth, lessons);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", dateOfBirth=" + dateOfBirth +
                ", lessons=" + lessons +
                '}';
    }
}





