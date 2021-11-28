package Lesson11.education;

public class LessonStorage {
    private Lesson[] lessons = new Lesson[16];
    private int size;

    public void add(Lesson lesson) {
        if (lessons.length == size) {
            extend();
        }
        lessons[size++] = lesson;
    }

    private void extend() {
        Lesson[] tmp = new Lesson[lessons.length + 10];

        for (int i = 0; i < lessons.length; i++) {
            tmp[i] = lessons[i];
        }
        lessons = tmp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(lessons[i]);
        }
    }


    public void deleteLessonByName(String name) {
        for (int i = 0; i < size; i++) {
            if (lessons[i].getName().equals(name)) {
                ArrayUtil.deleteByIndex(lessons, i, size);
                size--;
                System.out.println("Lesson has been deleted");
                break;
            }

        }
    }

    public Lesson getByName(String name) {
        for (int i = 0; i < size; i++) {
            if (lessons[i].getName().equals(name)) {
                return lessons[i];
            }
        }
        return null;
    }


}
