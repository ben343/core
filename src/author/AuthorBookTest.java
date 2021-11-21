package author;

import java.util.Scanner;

public class AuthorBookTest {

    private static Scanner scanner = new Scanner(System.in);
    private static AuthorStorage authorStorage = new AuthorStorage();
    private static BookStorage bookStorage = new BookStorage();

    private static final String EXIT = " 0";
    private static final String ADD_AUTHORS = " 1";
    private static final String ADD_BOOK = " 2";
    private static final String SEARCH_AUTHORS = " 3";
    private static final String SEARCH_AUTHORS_By_AGE = " 4";
    private static final String PRINT_AUTHORS = " 5";
    private static final String PRINT_BOOK = " 6";
    private static final String SEARCH_BOOK_BY_TITLE = " 7";

    public static void main(String[] args) {
        authorStorage.add(new Author("poxos", "poxosyan", 22, "poxosyan@mail.ru", "male"));
        authorStorage.add(new Author("petros", "petrosyan", 30, "petrsoyan@mail.ru", "male"));
        authorStorage.add(new Author("martiros", "martirosyan", 44, "martiros@mail.ru", "male"));


        boolean isRun = true;
        while (isRun) {
            printCommands();

            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_AUTHORS:
                    addAutor();
                    break;
                case ADD_BOOK:
                    addBook();
                    break;
                case SEARCH_AUTHORS:
                    searchAuthor();
                    break;
                case SEARCH_AUTHORS_By_AGE:
                    searchAuthorByAge();
                    break;
                case PRINT_AUTHORS:
                    authorStorage.print();
                    break;
                case PRINT_BOOK:
                    bookStorage.print();
                    break;
                case SEARCH_BOOK_BY_TITLE:
                    searchBookByTitle();
                    break;
                default:
                    System.out.println("invalid command");
            }
        }


    }

    private static void searchBookByTitle() {
        System.out.println("please input keyword");
        String keyword = scanner.nextLine();
        bookStorage.searchByTitle(keyword);
    }

    private static void addBook() {

        System.out.println("Please choose author s email");
        System.out.println("----------");
        authorStorage.print();
        System.out.println("----------");
        String email = scanner.nextLine();
        Author author = authorStorage.getByEmail(email);

        if (author != null) {
            System.out.println("please input book title");
            String title = scanner.nextLine();
            System.out.println("pleas input description");
            String description = scanner.nextLine();
            System.out.println("please input book prince");
            double prince = Double.parseDouble(scanner.nextLine());
            System.out.println("please input book count");
            int count = Integer.parseInt(scanner.nextLine());

            Book book = new Book(title, description, prince, count, author);
            bookStorage.add(book);
            System.out.println("tyank you book was added");

        } else {
            System.out.println("invalid email");
            addBook();
        }
    }

    private static void printCommands() {
        System.out.println("Please input" + EXIT + "for EXIT");
        System.out.println("Please input" + ADD_AUTHORS + " for ADD_AUTHORS");
        System.out.println("Please input" + ADD_BOOK + " for ADD_BOOK ");
        System.out.println("Please input" + SEARCH_AUTHORS + " for SEARCH_AUTHORS");
        System.out.println("Please input" + SEARCH_AUTHORS_By_AGE + " for SEARCH_AUTHORS_By_AGE");
        System.out.println("Please input" + PRINT_AUTHORS + " for PRINT_AUTHORS");
        System.out.println("Please input" + PRINT_BOOK + " PRINT_BOOK");
        System.out.println("Please input" + SEARCH_BOOK_BY_TITLE + " for SEARCH_BOOK_BT_TITLE");

    }

    private static void searchAuthorByAge() {
        System.out.println("Please input min age ");
        int minAge = Integer.parseInt(scanner.nextLine());
        System.out.println("Please input max age");
        int maxAge = Integer.parseInt(scanner.nextLine());
        authorStorage.searchAuthorByAge(minAge, maxAge);
    }

    private static void searchAuthor() {
        System.out.println("Please input keyword");
        String keyword = scanner.nextLine();
        authorStorage.searchAuthor(keyword);
    }


    private static void addAutor() {
        System.out.println("Please input author`s name");
        String name = scanner.nextLine();
        System.out.println("Please input author`s surname");
        String surname = scanner.nextLine();
        System.out.println("Please input author`s email");
        String email = scanner.nextLine();
        System.out.println("Please input author`s gender");
        String gender = scanner.nextLine();
        System.out.println("Please input author`s age");
        int age = Integer.parseInt(scanner.nextLine());
        Author author = new Author(name, surname, age, email, gender);
        authorStorage.add(author);
        System.out.println("Thank you! Author was added");

    }


}



