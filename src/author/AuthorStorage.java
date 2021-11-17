package author;

public class AuthorStorage {
    private Author1[] array = new Author1[10];


    private int size = 0;


    public void add(Author1 author) {
        if (array.length == size) {
            extend();
        }
        array[size++] = author;

    }

    public void getByIndex(int index) {
        if (index < 0 || index > array.length) {
            System.err.println("invalid index");
            // return null;
        }
    }

    private void extend() {
        Author1[] array1 = new Author1[array.length + 10];
        for (char i = 0; i < array.length; i++) {
            array1[i] = array[i];
        }
        array1 = array;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }


}