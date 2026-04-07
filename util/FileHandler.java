package util;

import model.Book;
import java.io.*;
import java.util.*;

public class FileHandler {

    private static final String FILE_NAME = "books.txt";

    public static void save(Collection<Book> books) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Book b : books) {
                bw.write(b.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file!");
        }
    }

    public static List<Book> load() {
        List<Book> list = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(Book.fromFileString(line));
            }
        } catch (IOException e) {
            System.out.println("Error loading file!");
        }

        return list;
    }
}