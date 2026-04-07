import service.*;
import model.Book;
import util.FileHandler;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibraryOperations service = new LibraryService();

        service.loadBooks(FileHandler.load());

        while (true) {
            System.out.println("\n1.Add 2.Remove 3.Issue 4.Return 5.Display 6.Exit 7.Search");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    service.addBook(new Book(id, title, author));
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    service.removeBook(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    service.issueBook(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    service.returnBook(sc.nextInt());
                    break;

                case 5:
                    service.displayBooks();
                    break;

                case 6:
                    FileHandler.save(service.getAllBooks());
                    System.out.println("Saved. Exiting...");
                    return;

                case 7:
                    sc.nextLine();
                    System.out.print("Enter keyword: ");
                    String keyword = sc.nextLine();

                    List<Book> results = ((LibraryService) service).searchByTitle(keyword);

                    if (results.isEmpty()) {
                        System.out.println("No books found.");
                    } else {
                        for (Book b : results) {
                            System.out.println(b);
                        }
                    }
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}