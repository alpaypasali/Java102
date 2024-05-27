package Week5.İçerik2.Book;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("To Kill a Mockingbird", 281, "Harper Lee", "1960-07-11");
        Book book2 = new Book("1984", 328, "George Orwell", "1949-06-08");
        Book book3 = new Book("Moby Dick", 635, "Herman Melville", "1851-10-18");
        Book book4 = new Book("The Great Gatsby", 180, "F. Scott Fitzgerald", "1925-04-10");
        Book book5 = new Book("Pride and Prejudice", 279, "Jane Austen", "1813-01-28");
        Book book6 = new Book("The Catcher in the Rye", 214, "J.D. Salinger", "1951-07-16");

        Set<Book> bookSet = new TreeSet<>();

        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        bookSet.add(book5);
        bookSet.add(book6);
        Set<Book> setPageCount = new TreeSet<>(Comparator.comparing(Book::getPageCount));
        setPageCount.addAll(bookSet);

        for (Book book: setPageCount) {
            System.out.println(book.getBookName());
        }

    }
}
