package model;

import java.time.LocalDate;

public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isIssued;
    private LocalDate issueDate;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }
    public LocalDate getIssueDate() { return issueDate; }

    public void issueBook() {
        this.isIssued = true;
        this.issueDate = LocalDate.now();
    }

    public void returnBook() {
        this.isIssued = false;
        this.issueDate = null;
    }

    public String toFileString() {
        return id + "," + title + "," + author + "," + isIssued + "," + issueDate;
    }

    public static Book fromFileString(String line) {
        String[] data = line.split(",");

        Book b = new Book(
                Integer.parseInt(data[0]),
                data[1],
                data[2]
        );

        if (Boolean.parseBoolean(data[3])) {
            b.issueBook();
            if (!data[4].equals("null")) {
                b.issueDate = LocalDate.parse(data[4]);
            }
        }

        return b;
    }

    @Override
    public String toString() {
        return id + " | " + title + " | " + author +
                (isIssued ? " | Issued on: " + issueDate : " | Available");
    }
}