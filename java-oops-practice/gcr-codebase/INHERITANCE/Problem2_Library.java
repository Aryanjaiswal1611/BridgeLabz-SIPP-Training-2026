// Problem 2: Library Management - Single Inheritance
// Book (superclass) -> Author (subclass)

class Book {
    protected String title;
    protected int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public void displayInfo() {
        System.out.println("Book: " + title + " (" + publicationYear + ")");
    }
}

class Author extends Book {
    private String authorName;
    private String bio;

    public Author(String title, int publicationYear, String authorName, String bio) {
        super(title, publicationYear);  // calling Book constructor
        this.authorName = authorName;
        this.bio = bio;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();  // reuse Book's displayInfo
        System.out.println("Author: " + authorName);
        System.out.println("Bio: " + bio);
    }
}

public class Problem2_Library {
    public static void main(String[] args) {
        System.out.println("\n--- Problem 2: Library Management ---\n");

        Book book = new Book("Generic Book", 2000);
        book.displayInfo();

        System.out.println();

        Author author = new Author("The Great Gatsby", 1925, "F. Scott Fitzgerald",
                                   "American novelist known for the Jazz Age.");
        author.displayInfo();
    }
}
