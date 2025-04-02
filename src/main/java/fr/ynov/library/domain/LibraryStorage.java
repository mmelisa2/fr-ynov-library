package fr.ynov.library.domain;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Loading the books from a file to not lose access to important data every time the app is relaunched.
    public class LibraryStorage {
        private static final String FILE_PATH = "library.data";

        public static void saveBooks(List<Book> books) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
                oos.writeObject(books);
                System.out.println("Books saved to file: " + FILE_PATH);
            } catch (IOException e) {
                System.err.println("Error saving books: " + e.getMessage());
            }
        }

        public static List<Book> loadBooks() {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                return new ArrayList<>(); // Returning empty list if file doesn't exist.
            }

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
                return (List<Book>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error loading books: " + e.getMessage());
                return new ArrayList<>();
            }
        }
    }