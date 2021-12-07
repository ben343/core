package Lesson11.education;

public interface Commands {
    String EXIT = "0";
    String LOGIN = "1";
    String REGISTER = "2";

    static void printCommands() {
        System.out.println("\u001B[34m" + "please input " + EXIT + " to EXIT");
        System.out.println("please input " + LOGIN + " for login");
        System.out.println("please input " + REGISTER + " for register");
    }
}
