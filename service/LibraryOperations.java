package service;

import model.Book;
import java.util.Collection;

public interface LibraryOperations {
    void addBook(Book book);
    void removeBook(int id);
    void issueBook(int id);
    void returnBook(int id);
    void displayBooks();
    Collection<Book> getAllBooks();
    void loadBooks(Collection<Book> books);
}