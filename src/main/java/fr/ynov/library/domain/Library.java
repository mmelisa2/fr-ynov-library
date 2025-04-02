package fr.ynov.library.domain;

import java.util.List;
import java.util.ArrayList;

public class Library {
    private final List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }
    public void addBook(String title, String author, Genre genre, int pages, Language language, String publisher, int publishedYear) {
        try {
            if (title == null || author == null || genre == null || language == null || publisher == null) {
                throw new IllegalArgumentException("All fields are required");
            }
            if (pages <= 0 || publishedYear <= 0) {
                throw new IllegalArgumentException("Page number and published year must be greater than 0");
            }

            Book newBook = new Book(title, author, genre, pages, language, publisher, publishedYear);
            books.add(newBook);
            System.out.println("Book added to library:" + newBook.getTitle());
            System.out.println("Author: " + newBook.getAuthor());
            System.out.println("Genre: " + newBook.getGenre());
            System.out.println("Pages: " + newBook.getPages());
            System.out.println("Language: " + newBook.getLanguage());
            System.out.println("Publisher: " + newBook.getPublisher());
            System.out.println("Published Year: " + newBook.getPublishedYear());
        } catch (IllegalArgumentException e){
            System.err.println("Error adding book to library" + e.getMessage());
        }
    }

    public List<Book> getBooks() {
        return books;
    }
    public void displayBooks(){
        if (books.isEmpty()){
            System.out.println("No books in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}
