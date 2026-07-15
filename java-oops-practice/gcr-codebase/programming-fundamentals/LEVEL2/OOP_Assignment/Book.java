class Book {

```
static String libraryName =
        "Central Library";

String title;
String author;
final String isbn;

public Book(String title,
            String author,
            String isbn) {

    this.title = title;
    this.author = author;
    this.isbn = isbn;
}

public static void displayLibraryName() {
    System.out.println("Library : " + libraryName);
}

public void display() {
    System.out.println(title + " | " + author + " | " + isbn);
}

public static void main(String[] args) {

    Book b1 =
            new Book(
                    "Java",
                    "James Gosling",
                    "ISBN101"
            );

    displayLibraryName();

    if (b1 instanceof Book) {
        b1.display();
    }
}
```

}
