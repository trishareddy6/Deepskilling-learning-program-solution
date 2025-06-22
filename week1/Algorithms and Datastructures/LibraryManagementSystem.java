package librarymanagement;

public class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LibraryManagementSystem {

    public static Book linearSearch(Book[] books, String targetTitle) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(targetTitle)) {
                return b;
            }
        }
        return null;
    }

    
    public static Book binarySearch(Book[] books, String targetTitle) {
        int low = 0, high = books.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(targetTitle);

            if (cmp == 0) return books[mid];
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book[] books = {
            new Book(101, "Data Structures", "Mark Allen"),
            new Book(102, "Java Programming", "Herbert Schildt"),
            new Book(103, "Algorithms", "CLRS"),
            new Book(104, "Operating Systems", "Silberschatz"),
            new Book(105, "Computer Networks", "Tanenbaum")
        };

        System.out.println("Enter the book title to search:");
        String inputTitle = sc.nextLine();

        System.out.println("\nUsing Linear Search:");
        Book linearResult = linearSearch(books, inputTitle);
        if (linearResult != null)
            System.out.println("Found: " + linearResult);
        else
            System.out.println("Book not found.");
        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));

        System.out.println("\nUsing Binary Search:");
        Book binaryResult = binarySearch(books, inputTitle);
        if (binaryResult != null)
            System.out.println("Found: " + binaryResult);
        else
            System.out.println("Book not found.");

        sc.close();
    }
}

Output:
Enter the book title to search:
Operating Systems

Using Linear Search:
Found: Book ID: 104, Title: Operating Systems, Author: Silberschatz

Using Binary Search:
Found: Book ID: 104, Title: Operating Systems, Author: Silberschatz
