package author;

public class BookStorage {
    private Book [] books = new Book[10];
    private int size = 0;


    public void add(Book book) {
        if (books.length == size) {
            extend();
        }
        books[size++] = book;

    }

    // public void getByIndex(int index) {
    //   if (index < 0 || index > array.length) {
    //     System.err.println("invalid index");
    // return null;
    //}
    //}

    private void extend() {
      Book [] tmp = new Book[books.length + 10];
        System.arraycopy(books, 0, tmp, 0, books.length);
        tmp = books;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(books[i]);
        }
    }

    public void searchByTitle(String keyword) {
        for (int i = 0; i <size ; i++) {
            if (books[i].getTitle().contains(keyword)){
                System.out.println(books[i]);
            }
        }

    }

    // public void searchAuthor(String keyword) {
     //   for (int i = 0; i < size; i++) {
       //     if (authors[i].getName().contains(keyword) ||
         //           authors[i].getSurname().contains(keyword)) {
           //     System.out.println(authors[i]);
            //}
        //}
    //}

    // public void searchAuthorByAge(int minAge, int maxAge) {
    //   for (int i = 0; i <size ; i++) {
    //     if (authors[i].getAge()>=minAge && authors[i].getAge()<=maxAge){
    //       System.out.println(authors[i]);
    // }

    //}
}
