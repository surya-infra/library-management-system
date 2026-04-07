package service;

import model.Book;
import exception.BookNotFoundException;

import java.util.*;

public class LibraryService implements LibraryOperations {

    private Map<Integer, Book> books = new HashMap<>();

    @Override
    public void addBook(Book book) {
        books.put(book.getId(), book);
        System.out.println("Book added!");
    }

    @Override
    public void removeBook(int id) {
        if (books.remove(id) != null) {
            System.out.println("Book removed!");
        } else {
            System.out.println("Book not found!");
        }
    }

    @Override
    public void issueBook(int id) {
        try {
            Book b = findBookOrThrow(id);

            if (b.isIssued()) {
                System.out.println("Already issued!");
            } else {
                b.issueBook();
                System.out.println("Book issued!");
            }

        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void returnBook(int id) {
        try {
            Book b = findBookOrThrow(id);

            if (!b.isIssued()) {
                System.out.println("Book not issued!");
            } else {
                b.returnBook();
                System.out.println("Book returned!");
            }

        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private Book findBookOrThrow(int id) throws BookNotFoundException {
        Book b = books.get(id);
        if (b == null) {
            throw new BookNotFoundException("Book with ID " + id + " not found!");
        }
        return b;
    }

    @Override
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book b : books.values()) {
            System.out.println(b);
        }
    }

    @Override
    public Collection<Book> getAllBooks() {
        return books.values();
    }

    @Override
    public void loadBooks(Collection<Book> list) {
        for (Book b : list) {
            books.put(b.getId(), b);
        }
    }

    // Search (no streams)
    public List<Book> searchByTitle(String keyword) {
        List<Book> result = new ArrayList<>();

        for (Book b : books.values()) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(b);
            }
        }

        return result;
    }
}