package author;

import java.util.Scanner;

public class AuthorTest {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("How many authors are there?");
        int a = scanner.nextInt();
        AuthorStorage as = new AuthorStorage();

        for (int i = 0; i < a; i++) {

            Author1 author = new Author1();
            as.add(new Author1());
            author.setName("Poxos");
            author.setSurname("Poxosyan");
            author.setEmail("Poxosyan@gmail.com");
            author.setAge(34);
            author.setGender("male");


        }

        as.print();
    }


}

