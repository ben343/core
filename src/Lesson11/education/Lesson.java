package Lesson11.education;


public class Lesson {
    private String name;
    private int duration;
    private String lecturerNa;
    private int prince;

    public Lesson(String name, int duration, String lecturerNa, int prince) {
        this.name = name;
        this.duration = duration;
        this.lecturerNa = lecturerNa;
        this.prince = prince;
    }

    public Lesson() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLecturerNa() {
        return lecturerNa;
    }

    public void setLecturerNa(String lecturerNa) {
        this.lecturerNa = lecturerNa;
    }

    public int getPrince() {
        return prince;
    }

    public void setPrince(int prince) {
        this.prince = prince;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", lecturerNa='" + lecturerNa + '\'' +
                ", prince=" + prince +
                '}';
    }
}
